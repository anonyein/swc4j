/*
 * Copyright (c) 2024. caoccao.com Sam Cao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.caoccao.javet.swc4j.ast.expr.lit;

import com.caoccao.javet.swc4j.ast.Swc4jAst;
import com.caoccao.javet.swc4j.ast.enums.Swc4jAstBigIntSign;
import com.caoccao.javet.swc4j.ast.enums.Swc4jAstType;
import com.caoccao.javet.swc4j.ast.interfaces.ISwc4jAst;
import com.caoccao.javet.swc4j.ast.interfaces.ISwc4jAstLit;
import com.caoccao.javet.swc4j.ast.interfaces.ISwc4jAstPropName;
import com.caoccao.javet.swc4j.ast.interfaces.ISwc4jAstTsLit;
import com.caoccao.javet.swc4j.ast.visitors.ISwc4jAstVisitor;
import com.caoccao.javet.swc4j.ast.visitors.Swc4jAstVisitorResponse;
import com.caoccao.javet.swc4j.jni2rust.*;
import com.caoccao.javet.swc4j.span.Swc4jSpan;
import com.caoccao.javet.swc4j.utils.AssertionUtils;
import com.caoccao.javet.swc4j.utils.StringUtils;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Jni2RustClass(filePath = Jni2RustFilePath.AstUtils, customFromJava = true, customToJava = true)
public class Swc4jAstBigInt
        extends Swc4jAst
        implements ISwc4jAstLit, ISwc4jAstPropName, ISwc4jAstTsLit {
    public static final String BIG_INT_SUFFIX = "n";
    @Jni2RustField(atom = true)
    protected Optional<String> raw;
    @Jni2RustField(ignore = true)
    protected Swc4jAstBigIntSign sign;
    @Jni2RustField(box = true)
    protected BigInteger value;

    @Jni2RustMethod
    public Swc4jAstBigInt(
            Swc4jAstBigIntSign sign,
            @Jni2RustParam(optional = true) String raw,
            Swc4jSpan span) {
        super(span);
        setRaw(raw);
        setSign(sign);
    }

    @Override
    public List<ISwc4jAst> getChildNodes() {
        return EMPTY_CHILD_NODES;
    }

    @Jni2RustMethod
    public Optional<String> getRaw() {
        return raw;
    }

    @Jni2RustMethod
    public Swc4jAstBigIntSign getSign() {
        return sign;
    }

    @Override
    public Swc4jAstType getType() {
        return Swc4jAstType.BigInt;
    }

    @Jni2RustMethod
    public BigInteger getValue() {
        return value;
    }

    public Swc4jAstBigInt setRaw(String raw) {
        this.raw = Optional.ofNullable(raw);
        value = StringUtils.isEmpty(raw)
                ? BigInteger.ZERO
                : new BigInteger(raw.substring(0, raw.length() - BIG_INT_SUFFIX.length()));
        return this;
    }

    public Swc4jAstBigInt setSign(Swc4jAstBigIntSign sign) {
        this.sign = AssertionUtils.notNull(sign, "Sign");
        return this;
    }

    public Swc4jAstBigInt setValue(BigInteger value) {
        this.value = AssertionUtils.notNull(value, "Value");
        raw = Optional.of(value.toString() + BIG_INT_SUFFIX);
        return this;
    }

    @Override
    public String toString() {
        return raw.orElse(null);
    }

    @Override
    public Swc4jAstVisitorResponse visit(ISwc4jAstVisitor visitor) {
        switch (visitor.visitBigInt(this)) {
            case Error:
                return Swc4jAstVisitorResponse.Error;
            case OkAndBreak:
                return Swc4jAstVisitorResponse.OkAndContinue;
            default:
                return super.visit(visitor);
        }
    }
}

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

package com.caoccao.javet.swc4j.ast.clazz;

import com.caoccao.javet.swc4j.ast.Swc4jAst;
import com.caoccao.javet.swc4j.ast.enums.Swc4jAstAccessibility;
import com.caoccao.javet.swc4j.ast.enums.Swc4jAstType;
import com.caoccao.javet.swc4j.ast.enums.Swc4jAstVisitorResponse;
import com.caoccao.javet.swc4j.ast.interfaces.ISwc4jAstClassMember;
import com.caoccao.javet.swc4j.ast.interfaces.ISwc4jAstExpr;
import com.caoccao.javet.swc4j.ast.interfaces.ISwc4jAstKey;
import com.caoccao.javet.swc4j.ast.ts.Swc4jAstTsTypeAnn;
import com.caoccao.javet.swc4j.ast.visitors.ISwc4jAstVisitor;
import com.caoccao.javet.swc4j.jni2rust.Jni2RustField;
import com.caoccao.javet.swc4j.span.Swc4jSpan;
import com.caoccao.javet.swc4j.utils.AssertionUtils;
import com.caoccao.javet.swc4j.utils.SimpleList;

import java.util.List;
import java.util.Optional;

public class Swc4jAstAutoAccessor
        extends Swc4jAst
        implements ISwc4jAstClassMember {
    @Jni2RustField(name = "is_override")
    protected final boolean _override;
    @Jni2RustField(name = "is_static")
    protected final boolean _static;
    protected final Optional<Swc4jAstAccessibility> accessibility;
    protected final List<Swc4jAstDecorator> decorators;
    protected final boolean definite;
    protected final ISwc4jAstKey key;
    protected final Optional<Swc4jAstTsTypeAnn> typeAnn;
    protected final Optional<ISwc4jAstExpr> value;

    public Swc4jAstAutoAccessor(
            ISwc4jAstKey key,
            ISwc4jAstExpr value,
            Swc4jAstTsTypeAnn typeAnn,
            boolean _static,
            List<Swc4jAstDecorator> decorators,
            Swc4jAstAccessibility accessibility,
            boolean _override,
            boolean definite,
            Swc4jSpan span) {
        super(span);
        this._override = _override;
        this._static = _static;
        this.accessibility = Optional.ofNullable(accessibility);
        this.decorators = SimpleList.immutable(AssertionUtils.notNull(decorators, "Decorators"));
        this.definite = definite;
        this.key = AssertionUtils.notNull(key, "Key");
        this.typeAnn = Optional.ofNullable(typeAnn);
        this.value = Optional.ofNullable(value);
        childNodes = SimpleList.copyOf(decorators);
        childNodes.add(key);
        childNodes.add(value);
        childNodes.add(typeAnn);
        childNodes = SimpleList.immutable(childNodes);
        updateParent();
    }

    public Optional<Swc4jAstAccessibility> getAccessibility() {
        return accessibility;
    }

    public List<Swc4jAstDecorator> getDecorators() {
        return decorators;
    }

    public ISwc4jAstKey getKey() {
        return key;
    }

    @Override
    public Swc4jAstType getType() {
        return Swc4jAstType.AutoAccessor;
    }

    public Optional<Swc4jAstTsTypeAnn> getTypeAnn() {
        return typeAnn;
    }

    public Optional<ISwc4jAstExpr> getValue() {
        return value;
    }

    public boolean isDefinite() {
        return definite;
    }

    public boolean isOverride() {
        return _override;
    }

    public boolean isStatic() {
        return _static;
    }

    @Override
    public Swc4jAstVisitorResponse visit(ISwc4jAstVisitor visitor) {
        switch (visitor.visitAutoAccessor(this)) {
            case Error:
                return Swc4jAstVisitorResponse.Error;
            case OkAndBreak:
                return Swc4jAstVisitorResponse.OkAndContinue;
            default:
                return super.visit(visitor);
        }
    }
}

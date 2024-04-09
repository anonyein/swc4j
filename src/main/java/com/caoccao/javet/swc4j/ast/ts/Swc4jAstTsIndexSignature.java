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

package com.caoccao.javet.swc4j.ast.ts;

import com.caoccao.javet.swc4j.ast.Swc4jAst;
import com.caoccao.javet.swc4j.utils.Swc4jAstSpan;
import com.caoccao.javet.swc4j.ast.enums.Swc4jAstType;
import com.caoccao.javet.swc4j.ast.interfaces.ISwc4jAstClassMember;
import com.caoccao.javet.swc4j.ast.interfaces.ISwc4jAstTsFnParam;
import com.caoccao.javet.swc4j.ast.interfaces.ISwc4jAstTsTypeElement;
import com.caoccao.javet.swc4j.jni2rust.Jni2RustField;
import com.caoccao.javet.swc4j.utils.AssertionUtils;
import com.caoccao.javet.swc4j.utils.SimpleList;

import java.util.List;
import java.util.Optional;

public class Swc4jAstTsIndexSignature
        extends Swc4jAst
        implements ISwc4jAstClassMember, ISwc4jAstTsTypeElement {
    @Jni2RustField(name = "is_static")
    protected final boolean _static;
    protected final List<ISwc4jAstTsFnParam> params;
    protected final boolean readonly;
    protected final Optional<Swc4jAstTsTypeAnn> typeAnn;

    public Swc4jAstTsIndexSignature(
            List<ISwc4jAstTsFnParam> params,
            Swc4jAstTsTypeAnn typeAnn,
            boolean readonly,
            boolean _static,
            Swc4jAstSpan span) {
        super(span);
        this._static = _static;
        this.params = AssertionUtils.notNull(params, "Params");
        this.readonly = readonly;
        this.typeAnn = Optional.ofNullable(typeAnn);
        childNodes = SimpleList.copyOf(params);
        childNodes.add(typeAnn);
        childNodes = SimpleList.immutable(childNodes);
        updateParent();
    }

    public List<ISwc4jAstTsFnParam> getParams() {
        return params;
    }

    @Override
    public Swc4jAstType getType() {
        return Swc4jAstType.TsIndexSignature;
    }

    public Optional<Swc4jAstTsTypeAnn> getTypeAnn() {
        return typeAnn;
    }

    public boolean isReadonly() {
        return readonly;
    }

    public boolean isStatic() {
        return _static;
    }
}

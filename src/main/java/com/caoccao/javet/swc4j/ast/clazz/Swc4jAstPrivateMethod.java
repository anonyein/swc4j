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

import com.caoccao.javet.swc4j.annotations.Nullable;
import com.caoccao.javet.swc4j.ast.Swc4jAst;
import com.caoccao.javet.swc4j.ast.enums.Swc4jAstAccessibility;
import com.caoccao.javet.swc4j.ast.enums.Swc4jAstMethodKind;
import com.caoccao.javet.swc4j.ast.enums.Swc4jAstType;
import com.caoccao.javet.swc4j.ast.interfaces.ISwc4jAstClassMember;
import com.caoccao.javet.swc4j.utils.AssertionUtils;
import com.caoccao.javet.swc4j.utils.SimpleList;

public class Swc4jAstPrivateMethod
        extends Swc4jAst
        implements ISwc4jAstClassMember {
    protected final boolean _abstract;
    protected final boolean _override;
    protected final boolean _static;
    @Nullable
    protected final Swc4jAstAccessibility accessibility;
    protected final Swc4jAstFunction function;
    protected final Swc4jAstPrivateName key;
    protected final Swc4jAstMethodKind kind;
    protected final boolean optional;

    public Swc4jAstPrivateMethod(
            Swc4jAstPrivateName key,
            Swc4jAstFunction function,
            Swc4jAstMethodKind kind,
            boolean _static,
            Swc4jAstAccessibility accessibility,
            boolean _abstract,
            boolean optional,
            boolean _override,
            int startPosition,
            int endPosition) {
        super(startPosition, endPosition);
        this._abstract = _abstract;
        this._override = _override;
        this._static = _static;
        this.accessibility = accessibility;
        this.function = function;
        this.key = AssertionUtils.notNull(key, "Key");
        this.kind = AssertionUtils.notNull(kind, "Kind");
        this.optional = optional;
        children = SimpleList.immutableOf(key, function);
        updateParent();
    }

    public Swc4jAstAccessibility getAccessibility() {
        return accessibility;
    }

    public Swc4jAstFunction getFunction() {
        return function;
    }

    public Swc4jAstPrivateName getKey() {
        return key;
    }

    public Swc4jAstMethodKind getKind() {
        return kind;
    }

    @Override
    public Swc4jAstType getType() {
        return Swc4jAstType.PrivateMethod;
    }

    public boolean isAbstract() {
        return _abstract;
    }

    public boolean isOverride() {
        return _override;
    }

    public boolean isStatic() {
        return _static;
    }
}

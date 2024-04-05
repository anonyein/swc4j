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

package com.caoccao.javet.swc4j.ast.module;

import com.caoccao.javet.swc4j.ast.Swc4jAst;
import com.caoccao.javet.swc4j.ast.Swc4jAstSpan;
import com.caoccao.javet.swc4j.ast.enums.Swc4jAstType;
import com.caoccao.javet.swc4j.ast.expr.Swc4jAstIdent;
import com.caoccao.javet.swc4j.ast.interfaces.ISwc4jAstImportSpecifier;
import com.caoccao.javet.swc4j.ast.interfaces.ISwc4jAstModuleExportName;
import com.caoccao.javet.swc4j.jni2rust.Jni2RustField;
import com.caoccao.javet.swc4j.utils.AssertionUtils;
import com.caoccao.javet.swc4j.utils.SimpleList;

import java.util.Optional;

public class Swc4jAstImportNamedSpecifier
        extends Swc4jAst
        implements ISwc4jAstImportSpecifier {
    protected final Optional<ISwc4jAstModuleExportName> imported;
    protected final Swc4jAstIdent local;
    @Jni2RustField(name = "is_type_only")
    protected final boolean typeOnly;

    public Swc4jAstImportNamedSpecifier(
            Swc4jAstIdent local,
            ISwc4jAstModuleExportName imported,
            boolean typeOnly,
            Swc4jAstSpan span) {
        super(span);
        this.imported = Optional.ofNullable(imported);
        this.local = AssertionUtils.notNull(local, "Local");
        this.typeOnly = typeOnly;
        childNodes = SimpleList.immutableOf(imported, local);
        updateParent();
    }

    public Optional<ISwc4jAstModuleExportName> getImported() {
        return imported;
    }

    public Swc4jAstIdent getLocal() {
        return local;
    }

    @Override
    public Swc4jAstType getType() {
        return Swc4jAstType.ImportNamedSpecifier;
    }

    public boolean isTypeOnly() {
        return typeOnly;
    }
}

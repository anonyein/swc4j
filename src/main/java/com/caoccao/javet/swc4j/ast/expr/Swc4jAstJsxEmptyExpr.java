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

package com.caoccao.javet.swc4j.ast.expr;

import com.caoccao.javet.swc4j.ast.Swc4jAst;
import com.caoccao.javet.swc4j.ast.Swc4jAstSpan;
import com.caoccao.javet.swc4j.ast.enums.Swc4jAstType;
import com.caoccao.javet.swc4j.ast.interfaces.ISwc4jAstExpr;
import com.caoccao.javet.swc4j.jni2rust.Jni2RustClass;

@Jni2RustClass(name = "JSXEmptyExpr")
public class Swc4jAstJsxEmptyExpr
        extends Swc4jAst
        implements ISwc4jAstExpr {

    public Swc4jAstJsxEmptyExpr(
            Swc4jAstSpan span) {
        super(span);
        childNodes = EMPTY_CHILD_NODES;
    }

    @Override
    public Swc4jAstType getType() {
        return Swc4jAstType.JsxEmptyExpr;
    }
}

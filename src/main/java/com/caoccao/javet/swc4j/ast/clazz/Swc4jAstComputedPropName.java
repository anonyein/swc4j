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
import com.caoccao.javet.swc4j.ast.Swc4jAstSpan;
import com.caoccao.javet.swc4j.ast.enums.Swc4jAstType;
import com.caoccao.javet.swc4j.ast.interfaces.ISwc4jAstExpr;
import com.caoccao.javet.swc4j.ast.interfaces.ISwc4jAstPropName;
import com.caoccao.javet.swc4j.utils.AssertionUtils;
import com.caoccao.javet.swc4j.utils.SimpleList;

public class Swc4jAstComputedPropName
        extends Swc4jAst
        implements ISwc4jAstPropName {
    protected final ISwc4jAstExpr expr;

    public Swc4jAstComputedPropName(
            ISwc4jAstExpr expr,
            Swc4jAstSpan span) {
        super(span);
        this.expr = AssertionUtils.notNull(expr, "Expr");
        children = SimpleList.immutableOf(expr);
        updateParent();
    }

    public ISwc4jAstExpr getExpr() {
        return expr;
    }

    @Override
    public Swc4jAstType getType() {
        return Swc4jAstType.ComputedPropName;
    }
}

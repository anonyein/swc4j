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

package com.caoccao.javet.swc4j.ast.lit;

import com.caoccao.javet.swc4j.ast.BaseTestSuiteSwc4jAst;
import com.caoccao.javet.swc4j.ast.expr.lit.Swc4jAstNull;
import com.caoccao.javet.swc4j.ast.program.Swc4jAstScript;
import com.caoccao.javet.swc4j.ast.stmt.Swc4jAstExprStmt;
import com.caoccao.javet.swc4j.ast.enums.Swc4jAstType;
import com.caoccao.javet.swc4j.exceptions.Swc4jCoreException;
import com.caoccao.javet.swc4j.outputs.Swc4jParseOutput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSwc4jAstNull extends BaseTestSuiteSwc4jAst {
    @Test
    public void test() throws Swc4jCoreException {
        String code = "null";
        Swc4jParseOutput output = swc4j.parse(code, tsScriptOptions);
        Swc4jAstScript script = output.getProgram().asScript();
        Swc4jAstExprStmt exprStmt = (Swc4jAstExprStmt) script.getBody().get(0);
        assertEquals(script, exprStmt.getParent());
        assertEquals(0, exprStmt.getStartPosition());
        assertEquals(4, exprStmt.getEndPosition());
        Swc4jAstNull astNull = (Swc4jAstNull) exprStmt.getExpr();
        assertEquals(exprStmt, astNull.getParent());
        assertEquals(Swc4jAstType.Null, astNull.getType());
        assertEquals(0, astNull.getStartPosition());
        assertEquals(4, astNull.getEndPosition());
    }
}

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

package com.caoccao.javet.swc4j;

import com.caoccao.javet.swc4j.enums.Swc4jMediaType;
import com.caoccao.javet.swc4j.exceptions.Swc4jCoreException;
import com.caoccao.javet.swc4j.options.Swc4jTranspileOptions;
import com.caoccao.javet.swc4j.outputs.Swc4jTranspileOutput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSwc4j {
    protected Swc4j swc4j;

    public TestSwc4j() {
        swc4j = new Swc4j();
    }

    @Test
    public void testGetVersion() {
        assertEquals("0.1.0", swc4j.getVersion());
    }

    @Test
    public void testTranspile() throws Swc4jCoreException {
        String code = "function add(a:number, b:number) { return a+b; }";
        String expectedCode = "function add(a, b) {\n" +
                "  return a + b;\n" +
                "}\n";
        String expectedMapPrefix = "//# sourceMappingURL=data:application/json;base64,";
        String fileName = "abc.ts";
        Swc4jTranspileOptions options = new Swc4jTranspileOptions()
                .setFileName(fileName)
                .setMediaType(Swc4jMediaType.TypeScript);
        Swc4jTranspileOutput output = swc4j.transpile(code, options);
        System.out.println(output.getCode());
        assertNotNull(output);
        assertEquals(expectedCode, output.getCode().substring(0, expectedCode.length()));
        assertEquals(
                expectedMapPrefix,
                output.getCode().substring(
                        expectedCode.length(),
                        expectedCode.length() + expectedMapPrefix.length()));
        assertNull(output.getSourceMap());
    }
}

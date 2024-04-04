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

package com.caoccao.javet.swc4j.ast.enums;

import com.caoccao.javet.swc4j.ast.Swc4jAstStore;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestSwc4jAstType {
    @Test
    public void testTypeMatch() {
        Pattern patternReturnType = Pattern.compile("return Swc4jAstType\\.(\\w+);");
        Swc4jAstStore.getInstance().getStructMap().forEach((expectedReturnType, filePath) -> {
            try {
                String content = new String(Files.readAllBytes(filePath), StandardCharsets.UTF_8);
                Matcher matcherReturnType = patternReturnType.matcher(content);
                if (matcherReturnType.find()) {
                    String returnType = matcherReturnType.group(1);
                    assertEquals(
                            expectedReturnType,
                            returnType,
                            "Type of " + filePath.toFile().getName() + " should match");
                }
            } catch (Exception e) {
                fail(e);
            }
        });
    }
}

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
import com.caoccao.javet.swc4j.enums.Swc4jParseMode;
import com.caoccao.javet.swc4j.interfaces.ISwc4jLogger;
import com.caoccao.javet.swc4j.options.Swc4jMinifyOptions;
import com.caoccao.javet.swc4j.options.Swc4jParseOptions;
import com.caoccao.javet.swc4j.options.Swc4jTranspileOptions;
import com.caoccao.javet.swc4j.utils.SimpleList;
import com.caoccao.javet.swc4j.utils.Swc4jDefaultLogger;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTestSuite {
    protected Swc4jMinifyOptions jsModuleMinifyOptions;
    protected Swc4jParseOptions jsModuleParseOptions;
    protected Swc4jTranspileOptions jsModuleTranspileOptions;
    protected Swc4jMinifyOptions jsScriptMinifyOptions;
    protected Swc4jParseOptions jsScriptParseOptions;
    protected Swc4jTranspileOptions jsScriptTranspileOptions;
    protected Swc4jMinifyOptions jsxModuleMinifyOptions;
    protected Swc4jParseOptions jsxModuleParseOptions;
    protected Swc4jTranspileOptions jsxModuleTranspileOptions;
    protected Swc4jMinifyOptions jsxScriptMinifyOptions;
    protected Swc4jParseOptions jsxScriptParseOptions;
    protected Swc4jTranspileOptions jsxScriptTranspileOptions;
    protected ISwc4jLogger logger;
    protected Swc4j swc4j;
    protected Swc4jMinifyOptions tsModuleMinifyOptions;
    protected Swc4jParseOptions tsModuleParseOptions;
    protected Swc4jTranspileOptions tsModuleTranspileOptions;
    protected Swc4jMinifyOptions tsScriptMinifyOptions;
    protected Swc4jParseOptions tsScriptParseOptions;
    protected Swc4jTranspileOptions tsScriptTranspileOptions;

    public BaseTestSuite() {
        logger = new Swc4jDefaultLogger(getClass().getName());
        swc4j = new Swc4j();
    }

    @BeforeEach
    protected void beforeEach() {
        jsModuleMinifyOptions = new Swc4jMinifyOptions();
        jsModuleParseOptions = new Swc4jParseOptions();
        jsModuleTranspileOptions = new Swc4jTranspileOptions();
        jsScriptMinifyOptions = new Swc4jMinifyOptions();
        jsScriptParseOptions = new Swc4jParseOptions();
        jsScriptTranspileOptions = new Swc4jTranspileOptions();
        jsxModuleMinifyOptions = new Swc4jMinifyOptions();
        jsxModuleParseOptions = new Swc4jParseOptions();
        jsxModuleTranspileOptions = new Swc4jTranspileOptions();
        jsxScriptMinifyOptions = new Swc4jMinifyOptions();
        jsxScriptParseOptions = new Swc4jParseOptions();
        jsxScriptTranspileOptions = new Swc4jTranspileOptions();
        tsModuleMinifyOptions = new Swc4jMinifyOptions();
        tsModuleParseOptions = new Swc4jParseOptions();
        tsModuleTranspileOptions = new Swc4jTranspileOptions();
        tsScriptMinifyOptions = new Swc4jMinifyOptions();
        tsScriptParseOptions = new Swc4jParseOptions();
        tsScriptTranspileOptions = new Swc4jTranspileOptions();
        SimpleList.of(
                jsModuleMinifyOptions,
                jsModuleParseOptions,
                jsModuleTranspileOptions,
                jsScriptMinifyOptions,
                jsScriptParseOptions,
                jsScriptTranspileOptions
        ).forEach(options -> options.setMediaType(Swc4jMediaType.JavaScript));
        SimpleList.of(
                jsxModuleMinifyOptions,
                jsxModuleParseOptions,
                jsxModuleTranspileOptions,
                jsxScriptMinifyOptions,
                jsxScriptParseOptions,
                jsxScriptTranspileOptions
        ).forEach(options -> options.setMediaType(Swc4jMediaType.Jsx));
        SimpleList.of(
                tsModuleMinifyOptions,
                tsModuleParseOptions,
                tsModuleTranspileOptions,
                tsScriptMinifyOptions,
                tsScriptParseOptions,
                tsScriptTranspileOptions
        ).forEach(options -> options.setMediaType(Swc4jMediaType.TypeScript));
        SimpleList.of(
                jsModuleMinifyOptions,
                jsModuleParseOptions,
                jsModuleTranspileOptions,
                jsxModuleMinifyOptions,
                jsxModuleParseOptions,
                jsxModuleTranspileOptions,
                tsModuleMinifyOptions,
                tsModuleParseOptions,
                tsModuleTranspileOptions
        ).forEach(options -> options.setParseMode(Swc4jParseMode.Module));
        SimpleList.of(
                jsScriptMinifyOptions,
                jsScriptParseOptions,
                jsScriptTranspileOptions,
                jsxScriptMinifyOptions,
                jsxScriptParseOptions,
                jsxScriptTranspileOptions,
                tsScriptMinifyOptions,
                tsScriptParseOptions,
                tsScriptTranspileOptions
        ).forEach(options -> options.setParseMode(Swc4jParseMode.Script));
    }
}

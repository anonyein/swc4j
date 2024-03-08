/*
* Copyright (c) 2024. caoccao.com Sam Cao
* All rights reserved.

* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at

* http://www.apache.org/licenses/LICENSE-2.0

* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

use jni::JNIEnv;
use jni::objects::JClass;
use jni::sys::{jobject, jstring};
use options::FromJniType;

use std::ptr::null_mut;

pub mod core;
pub mod options;
pub mod utils;

#[no_mangle]
pub extern "system" fn Java_com_caoccao_javet_swc4j_Swc4jNative_coreGetVersion<'local>(
  env: JNIEnv<'local>,
  _: JClass<'local>,
) -> jstring {
  utils::converter::string_to_jstring(&env, core::get_version())
}

#[no_mangle]
pub extern "system" fn Java_com_caoccao_javet_swc4j_Swc4jNative_coreTranspile<'local>(
  mut env: JNIEnv<'local>,
  _: JClass<'local>,
  code: jstring,
  options: jobject,
) -> jobject {
  let code = utils::converter::jstring_to_string(&mut env, code);
  let options = options::TranspileOptions::from_jni_type(&mut env, options);
  core::transpile(code, options);
  null_mut()
}

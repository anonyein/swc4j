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

use jni::objects::JString;
use jni::sys::{jboolean, jint, jobject, jstring};
use jni::JNIEnv;
use std::ptr::null_mut;

use deno_media_type::MediaType;

pub fn jstring_to_string<'local>(env: &mut JNIEnv<'local>, s: jstring) -> String {
  unsafe {
    match env.get_string(&JString::from_raw(s)) {
      Ok(s) => s.into(),
      Err(_) => "".to_owned(),
    }
  }
}

pub fn media_type_id_to_media_type(media_type_id: jint) -> MediaType {
  match media_type_id {
    0 => MediaType::JavaScript,
    1 => MediaType::Jsx,
    2 => MediaType::Mjs,
    3 => MediaType::Cjs,
    4 => MediaType::TypeScript,
    5 => MediaType::Mts,
    6 => MediaType::Cts,
    7 => MediaType::Dts,
    8 => MediaType::Dmts,
    9 => MediaType::Dcts,
    10 => MediaType::Tsx,
    11 => MediaType::Json,
    12 => MediaType::Wasm,
    13 => MediaType::TsBuildInfo,
    14 => MediaType::SourceMap,
    _ => MediaType::Unknown,
  }
}

pub fn string_to_jstring<'local>(env: &JNIEnv<'local>, s: &'local str) -> jstring {
  match env.new_string(s) {
    Ok(s) => s.to_owned(),
    Err(_) => null_mut(),
  }
}
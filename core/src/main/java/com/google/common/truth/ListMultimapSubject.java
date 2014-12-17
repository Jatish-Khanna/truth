/*
 * Copyright (c) 2014 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.common.truth;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.SetMultimap;

import java.util.List;

/**
 * Type-specific extensions of {@link com.google.common.collect.Multimap} subjects for
 * {@link com.google.common.collect.ListMultimap} subjects.
 *
 * @author Daniel Ploch
 */
public class ListMultimapSubject<
    S extends ListMultimapSubject<S, K, V, M>, K, V, M extends ListMultimap<K, V>>
    extends MultimapSubject<S, K, V, M> {

  ListMultimapSubject(FailureStrategy failureStrategy, M multimap) {
    super(failureStrategy, multimap);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  static <K, V, M extends ListMultimap<K, V>>
  ListMultimapSubject<? extends ListMultimapSubject<?, K, V, M>, K, V, M> create(
      FailureStrategy failureStrategy, ListMultimap<K, V> multimap) {
    return new ListMultimapSubject(failureStrategy, multimap);
  }

  /**
   * @deprecated {@code #isEqualTo} A SetMultimap can never compare equal with a ListMultimap if
   *      either Multimap is non-empty, because {@link java.util.Set} and {@link List} can never
   *      compare equal.  Prefer
   *      {@link MultimapSubject#containsExactly(com.google.common.collect.Multimap)} instead.
   *      Consult {@link com.google.common.collect.Multimap#equals} for more information.
   */
  @Deprecated
  public void isEqualTo(SetMultimap<?, ?> other) {
    super.isEqualTo(other);
  }
}

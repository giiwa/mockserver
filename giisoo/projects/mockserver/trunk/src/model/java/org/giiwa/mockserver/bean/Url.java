/*
 * Copyright 2015 JIHU, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
package org.giiwa.mockserver.bean;

import org.giiwa.core.bean.Bean;
import org.giiwa.core.bean.Beans;
import org.giiwa.core.bean.Table;
import org.giiwa.core.bean.Helper;
import org.giiwa.core.bean.Helper.V;
import org.giiwa.core.bean.Helper.W;
import org.giiwa.core.bean.Column;
import org.giiwa.core.bean.X;

// TODO: Auto-generated Javadoc
/**
 * Demo bean
 * 
 * @author joe
 * 
 */
@Table(name = "gi_urlmapping")
public class Url extends Bean {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Column(name = X.ID)
  String                    id;

  @Column(name = "url")
  String                    url;

  @Column(name = "enabled")
  int                       enabled;

  @Column(name = "type")
  String                    type;

  @Column(name = "content")
  String                    content;

  public String getId() {
    return id;
  }

  public int getEnabled() {
    return enabled;
  }

  public String getType() {
    return type;
  }

  public String getUrl() {
    return url;
  }

  public String getContent() {
    return content;
  }

  // ------------

  /**
   * Creates the.
   *
   * @param url
   *          the url
   * @param v
   *          the v
   * @return the string
   */
  public static String create(String url, V v) {
    /**
     * generate a unique id in distribute system
     */
    try {
      if (!exists(url)) {
        Helper.insert(v.set(X.ID, url), Url.class);
        return url;
      }
    } catch (Exception e1) {
      log.error(e1.getMessage(), e1);
    }
    return null;
  }

  /**
   * Exists.
   *
   * @param id
   *          the id
   * @return true, if successful
   */
  public static boolean exists(String id) {
    try {
      return Helper.exists(id, Url.class);
    } catch (Exception e1) {
      log.error(e1.getMessage(), e1);
    }
    return false;
  }

  /**
   * Update.
   *
   * @param id
   *          the id
   * @param v
   *          the v
   * @return the int
   */
  public static int update(String id, V v) {
    return Helper.update(id, v, Url.class);
  }

  /**
   * Load.
   *
   * @param q
   *          the q
   * @param s
   *          the s
   * @param n
   *          the n
   * @return the beans
   */
  public static Beans<Url> load(W q, int s, int n) {
    return Helper.load(q.sort(X.ID, 1), s, n, Url.class);
  }

  /**
   * Load.
   *
   * @param id
   *          the id
   * @return the url
   */
  public static Url load(String id) {
    return Helper.load(id, Url.class);
  }

  /**
   * Delete.
   *
   * @param id
   *          the id
   */
  public static void delete(String id) {
    Helper.delete(id, Url.class);
  }

}

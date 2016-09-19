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
package org.giiwa.mockserver.web.admin;

import org.giiwa.core.bean.Beans;
import org.giiwa.core.bean.X;
import org.giiwa.core.json.JSON;
import org.giiwa.core.bean.Helper.V;
import org.giiwa.core.bean.Helper.W;
import org.giiwa.mockserver.bean.Url;
import org.giiwa.framework.web.Model;
import org.giiwa.framework.web.Path;

// TODO: Auto-generated Javadoc
public class url extends Model {

  /* (non-Javadoc)
   * @see org.giiwa.framework.web.Model#onGet()
   */
  @Path(login = true, access = "access.config.admin")
  public void onGet() {
    int s = this.getInt("s");
    int n = this.getInt("n", 20, "number.per.page");

    W q = W.create();
    String name = this.getString("name");

    if (!X.isEmpty(name) && X.isEmpty(path)) {
      q.and("url", name, W.OP_LIKE);
      this.set("name", name);
    }

    int enabled = this.getInt("enabled", -1);
    if (enabled > -1 && X.isEmpty(path)) {
      q.and("enabled", enabled);
      this.set("enabled", enabled);
    }

    Beans<Url> bs = Url.load(q, s, n);
    this.set(bs, s, n);

    this.show("/admin/url.index.html");
  }

  /**
   * Delete.
   */
  @Path(path = "delete", login = true, access = "access.config.admin")
  public void delete() {
    String id = this.getString("id");
    Url.delete(id);
    JSON jo = new JSON();
    jo.put(X.STATE, 200);
    this.response(jo);
  }

  /**
   * Creates the.
   */
  @Path(path = "create", login = true, access = "access.config.admin")
  public void create() {
    if (method.isPost()) {
      JSON jo = this.getJSON();
      V v = V.create().copy(jo, "url", "type");
      v.set("enabled", X.isSame(this.getString("enabled"), "on") ? 0 : 1);
      v.set("content", this.getHtml("content"));
      String id = Url.create(this.getString("url"), v);

      this.set(X.MESSAGE, lang.get("create.success"));
      onGet();
      return;
    }

    this.show("/admin/url.create.html");
  }

  /**
   * Edits the.
   */
  @Path(path = "edit", login = true, access = "access.demo.admin")
  public void edit() {
    String id = this.getString("id");
    if (method.isPost()) {
      JSON jo = this.getJSON();
      V v = V.create().copy(jo, "type");
      v.set("enabled", X.isSame(this.getString("enabled"), "on") ? 0 : 1);
      v.set("content", this.getHtml("content"));
      Url.update(id, v);

      this.set(X.MESSAGE, lang.get("save.success"));
      onGet();
      return;
    }

    Url d = Url.load(id);
    this.set(d.getJSON());
    this.set("id", id);
    this.show("/admin/url.edit.html");
  }

}

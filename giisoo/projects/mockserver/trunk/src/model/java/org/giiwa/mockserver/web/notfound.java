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
package org.giiwa.mockserver.web;

import org.giiwa.framework.web.Model;
import org.giiwa.framework.web.Path;
import org.giiwa.mockserver.bean.Url;

/**
 * web api: /demo
 * 
 * @author joe
 * 
 */
public class notfound extends Model {

  /* (non-Javadoc)
   * @see org.giiwa.framework.web.Model#onGet()
   */
  @Path()
  public void onGet() {
    String uri = this.getURI();
    Url u1 = Url.load(uri);
    if (u1 != null && u1.getEnabled() == 0) {
      this.setContentType(u1.getType());
      this.print(u1.getContent());
    } else {
      this.notfound();
    }
  }

}

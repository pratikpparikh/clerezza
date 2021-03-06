/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.clerezza.platform.typerendering.scala

import java.io.IOException
import java.io.OutputStream
import java.net.URI
import javax.ws.rs.core.MediaType
import org.apache.clerezza.platform.typerendering.TypeRenderlet.RequestProperties
import org.apache.clerezza.platform.typerendering._
import org.apache.clerezza.rdf.core.UriRef
import org.apache.clerezza.rdf.utils.GraphNode
import org.osgi.service.component.ComponentContext
import org.apache.clerezza.rdf.ontologies._
import org.apache.clerezza.rdf.core._
import org.apache.clerezza.rdf.utils._
import org.apache.clerezza.rdf.scala.utils.Preamble._

/**
 * A trait to simplify development of TypeRenderlets in Scala.
 * <br/>
 * Classes mixing in this class will define the method renderedPage(Arguments) to deliver
 * the representation of the resource.
 * <br/>
 * There's typically only one instance of a AbstractRenderlet while a new instance
 * of RenderedPage is generated for each request.
 *
 * An example of a subclass:
 *
 * class BookFormRenderlet extends SRenderlet {
 *
 *   override def renderedPage(arguments: RenderedPage.Arguments) = {
 *    new XmlResult(arguments) {
 *
 *      override def content = <div xmlns="http://www.w3.org/1999/xhtml">
 *         ....
 *      </div>
 *    }
 *   }
 * }
 */
trait SRenderlet extends TypeRenderlet {

  def renderedPage(renderingArguments: XmlResult.Arguments): XmlResult

  def ifx[T](con:  => Boolean)(f: => T) :  T = {
    if (con) f else null.asInstanceOf[T]
  }

  val resultDocModifier = org.apache.clerezza.platform.typerendering.ResultDocModifier.getInstance();

  @throws(classOf[IOException])
  override def render(res: GraphNode, context: GraphNode,
          sharedRenderingValues: java.util.Map[String, Object],
          renderer: CallbackRenderer ,
          requestProperties: RequestProperties,
          os: OutputStream) = {
      if (os == null) {
        throw new IllegalArgumentException("Exception!")
      }
      val modeOption = if (requestProperties.getMode != null) {Some(requestProperties.getMode)} else {None}
      renderedPage(
        XmlResult.Arguments(res, context, sharedRenderingValues, renderer,
                   modeOption, 
                   requestProperties.getMediaType, requestProperties, os));

  }

  override def getMediaType() = MediaType.APPLICATION_XHTML_XML_TYPE

  def getModePattern = "naked"

}


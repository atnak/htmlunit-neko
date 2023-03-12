/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.htmlunit.cyberneko.html.dom;

import org.w3c.dom.Document;
import org.w3c.dom.html.HTMLIFrameElement;

/**
 * @author <a href="mailto:arkin@exoffice.com">Assaf Arkin</a>
 * @see org.w3c.dom.html.HTMLIFrameElement
 * @see org.htmlunit.cyberneko.xerces.dom.ElementImpl
 */
public class HTMLIFrameElementImpl
    extends HTMLElementImpl
    implements HTMLIFrameElement
{

    @Override
    public String getAlign()
    {
        return capitalize( getAttribute( "align" ) );
    }


    @Override
    public void setAlign( String align )
    {
        setAttribute( "align", align );
    }


    @Override
    public String getFrameBorder()
    {
        return getAttribute( "frameborder" );
    }


    @Override
    public void setFrameBorder( String frameBorder )
    {
        setAttribute( "frameborder", frameBorder );
    }


    @Override
    public String getHeight()
    {
        return getAttribute( "height" );
    }


    @Override
    public void setHeight( String height )
    {
        setAttribute( "height", height );
    }

    @Override
    public String getLongDesc()
    {
        return getAttribute( "longdesc" );
    }


    @Override
    public void setLongDesc( String longDesc )
    {
        setAttribute( "longdesc", longDesc );
    }


    @Override
    public String getMarginHeight()
    {
        return getAttribute( "marginheight" );
    }


    @Override
    public void setMarginHeight( String marginHeight )
    {
        setAttribute( "marginheight", marginHeight );
    }


    @Override
    public String getMarginWidth()
    {
        return getAttribute( "marginwidth" );
    }


    @Override
    public void setMarginWidth( String marginWidth )
    {
        setAttribute( "marginwidth", marginWidth );
    }


      @Override
    public String getName()
    {
        return getAttribute( "name" );
    }


    @Override
    public void setName( String name )
    {
        setAttribute( "name", name );
    }


    @Override
    public String getScrolling()
    {
        return capitalize( getAttribute( "scrolling" ) );
    }


    @Override
    public void setScrolling( String scrolling )
    {
        setAttribute( "scrolling", scrolling );
    }


       @Override
    public String getSrc()
    {
        return getAttribute( "src" );
    }


    @Override
    public void setSrc( String src )
    {
        setAttribute( "src", src );
    }


      @Override
    public String getWidth()
    {
        return getAttribute( "width" );
    }


    @Override
    public void setWidth( String width )
    {
        setAttribute( "width", width );
    }


    /**
     * Constructor requires owner document.
     *
     * @param owner The owner HTML document
     */
    public HTMLIFrameElementImpl( HTMLDocumentImpl owner, String name )
    {
        super( owner, name );
    }


    @Override
    public Document getContentDocument() {
        // TODO Auto-generated method stub
        return null;
    }


}


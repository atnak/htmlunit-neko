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

import org.w3c.dom.html.HTMLDListElement;

/**
 * @author <a href="mailto:arkin@exoffice.com">Assaf Arkin</a>
 * @see org.w3c.dom.html.HTMLDListElement
 * @see org.htmlunit.cyberneko.xerces.dom.ElementImpl
 */
public class HTMLDListElementImpl
    extends HTMLElementImpl
    implements HTMLDListElement
{

    @Override
    public boolean getCompact()
    {
        return getBinary( "compact" );
    }


    @Override
    public void setCompact( boolean compact )
    {
        setAttribute( "compact", compact );
    }


      /**
     * Constructor requires owner document.
     *
     * @param owner The owner HTML document
     */
    public HTMLDListElementImpl( HTMLDocumentImpl owner, String name )
    {
        super( owner, name );
    }


}


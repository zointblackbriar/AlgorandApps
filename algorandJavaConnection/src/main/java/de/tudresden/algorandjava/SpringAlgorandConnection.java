/*
 * Copyright 2022-2023 Orcun Oruc
 *
 * You should have received a copy of a license with this program. 
 *
 * You may not use, copy, modify, sublicense, or distribute the Program or any
 * portion of it, except as expressly provided under the given license.
 */
package de.tudresden.algorandjava;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

import java.util.logging.Logger;


/**
 * TODO DOCUMENT ME!
 *
 * @author $author$
 */
@ComponentScan
@SpringBootApplication
public class SpringAlgorandConnection {

    //~ Static fields/initializers -----------------------------------------------------------------------------------------------

    /**
     * TODO DOCUMENT ME!
     */
    private static final Logger logger = Logger.getLogger(SpringAlgorandConnection.class.getName());

    //~ Methods ------------------------------------------------------------------------------------------------------------------

    /**
     * TODO DOCUMENT ME!
     *
     * @param  args TODO DOCUMENT ME!
     *
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
    }
}

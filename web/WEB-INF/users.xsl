<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : users.xsl
    Created on : 30 September 2018, 5:29 PM
    Author     : Renwei
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="users">
        <html>
            <head>
            <title>User Page</title>
            </head>
            <body>
                <p>test</p>
                <xsl:apply-templates/> 
            </body>
        </html>
    </xsl:template>
   
    <xsl:template match="users">
        <table>
            <thead>
                <tr>
                    <th>Email</th>
                    <th>Full name</th>
                    <th>Password</th>
                    <th>Phone Number</th>
                    <th>Address</th>

                </tr>
            </thead>
            <tbody>
                <xsl:apply-templates/>
            </tbody>
        </table>     		 		
    </xsl:template>
    
    <xsl:template match="email">
        <tr>
        </tr>
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    	
    <xsl:template match="name">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>	
    
    <xsl:template match="password">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>	
    
    <xsl:template match="phoneNumber">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>	

    <xsl:template match="address">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>	
    
</xsl:stylesheet>
<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="PERSONS">
        <html>
            <head>
                <link rel="stylesheet" href="style.css"/>
            </head>
            <body>
                <h1>My favorite people</h1>
                <table class="table">
                    <thead>
                        <tr>
                            <td>PersonID</td>
                            <td>Name</td>
                            <td>Address</td>
                            <td>Telephone</td>
                            <td>Fax</td>
                            <td>E-Mail</td>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:for-each select="Person">
                            <tr>
                                <td>
                                    <xsl:value-of select="id"></xsl:value-of>
                                </td>
                                <td>
                                    <xsl:value-of select="Name"></xsl:value-of>
                                </td>
                                <td>
                                    <xsl:value-of select="Addres"></xsl:value-of>
                                </td>
                                <td>
                                    <xsl:value-of select="Telephone"></xsl:value-of>
                                </td>
                                <td>
                                    <xsl:value-of select="Fax"></xsl:value-of>
                                </td>
                                <td>
                                    <xsl:value-of select="E-mail"></xsl:value-of>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </tbody>
                </table>
            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>

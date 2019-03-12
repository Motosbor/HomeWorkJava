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
                        <xsl:for-each select="Person">
                            <p>Title:<xsl:apply-templates select="id"/></p>
                            <p>Name:<xsl:apply-templates select="Name"/></p>
                        </xsl:for-each>
            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>

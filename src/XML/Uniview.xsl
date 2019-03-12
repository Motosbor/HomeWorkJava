<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="UNIVERSITY">
        <html>
            <head>
                <link rel="stylesheet" href="style.css"/>
            </head>

            <body>
                <h1>My University</h1>
                <table class="table">
                    <thead>
                        <tr>
                            <td>Class(Аудитория)</td>
                            <td>Noofstudents(Кол-во студентов)</td>
                            <td>Noofpresent(Кол-во стундентов</td>
                            <td>Noofsections</td>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:for-each select="Class">

                            <tr>
                                <xsl:choose>
                                    <xsl:when test="id=1">
                                        <td>
                                            <xsl:value-of select="id"></xsl:value-of>st
                                        </td>
                                    </xsl:when>
                                    <xsl:when test="id=2">
                                        <td>
                                        <xsl:value-of select="id"></xsl:value-of>nd
                                        </td>
                                    </xsl:when>
                                    <xsl:when test="id=3">
                                        <td>
                                            <xsl:value-of select="id"></xsl:value-of>rd
                                        </td>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <td>
                                        <xsl:value-of select="id"></xsl:value-of>th
                                        </td>
                                    </xsl:otherwise>
                                </xsl:choose>
                                <td>
                                    <xsl:value-of select="No_of_Students"></xsl:value-of>
                                </td>
                                <td>
                                    <xsl:value-of select="No_of_Present"></xsl:value-of>
                                </td>
                                <td>
                                    <xsl:value-of select="No_of_Section"></xsl:value-of>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </tbody>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>

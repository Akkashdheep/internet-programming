<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Employee Salaries</title>
                <style>
                    table {
                        border-collapse: collapse;
                        width: 100%;
                    }
                    th, td {
                        border: 1px solid #dddddd;
                        text-align: left;
                        padding: 8px;
                    }
                    tr:nth-child(even) {
                        background-color: #f2f2f2;
                    }
                    .highlight {
                        background-color: yellow;
                    }
                </style>
            </head>
            <body>
                <h2>Employee Salaries</h2>
                <table>
                    <tr>
                        <th>Name</th>
                        <th>Salary</th>
                    </tr>
                    <xsl:apply-templates select="/employees/employee"/>
                </table>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="employee">
        <xsl:variable name="salary" select="salary"/>
        <tr>
            <td><xsl:value-of select="name"/></td>
            <td>
                <xsl:choose>
                    <xsl:when test="$salary > 50000">
                        <span class="highlight"><xsl:value-of select="salary"/></span>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="salary"/>
                    </xsl:otherwise>
                </xsl:choose>
            </td>
        </tr>
    </xsl:template>
</xsl:stylesheet>

<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="vendas">
		<h2>Vendas</h2>
		<p>
			Forma de Pagamento:
			<xsl:value-of select="formaDePagamento" />
		</p>
		<xsl:apply-templates select="produtos" />
	</xsl:template>
	<xsl:template match="produtos">
	<h3>Produtos</h3>
		<xsl:apply-templates select="produto" />
	</xsl:template>
	<xsl:template match="produto">
		<p>
			Titulo:
			<xsl:value-of select="nome" />
		</p>
		<p>
			Preço:
			<xsl:value-of select="preço" />
		</p>
	</xsl:template>
</xsl:stylesheet>
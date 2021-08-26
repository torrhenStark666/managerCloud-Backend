 DROP SCHEMA IF EXISTS managerCloudBD;
-- Criador: Alecsander
-- CRIANDO BANCO VAZIO

CREATE SCHEMA IF NOT EXISTS managerCloudBD DEFAULT CHARACTER SET utf8;
USE managerCloudBD;

-- INICIO TABELAS BASE

-- Contato
-- Mapeada

CREATE TABLE IF NOT EXISTS tb_contato(
	id_contato 				INT AUTO_INCREMENT PRIMARY KEY,
	nome					VARCHAR(50),
	contato 				VARCHAR(50),
    excluido				BOOLEAN DEFAULT FALSE
);

-- Endereço
-- Mapeada

CREATE TABLE IF NOT EXISTS tb_endereco(
	id_endereco 			INT AUTO_INCREMENT PRIMARY KEY,
	estado 					VARCHAR(50),
	bairro 					VARCHAR(50),
	endereco 				VARCHAR(50),
	complemento 			VARCHAR(50),
	municipio 				VARCHAR(50),
	numero 					INT,
	cep 					INT,
    excluido				BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS tb_empresa(
	id_empresa					INT AUTO_INCREMENT PRIMARY KEY,
	id_endereco					INT,
	cnpj						VARCHAR(20),
	nome_fantasia				VARCHAR(50),
	razao_social				VARCHAR(50),
	inscricao_estadual			VARCHAR(20),
	inscricao_municipal			VARCHAR(20),
	excluido					BOOLEAN DEFAULT FALSE,
	FOREIGN KEY(id_endereco)	REFERENCES tb_endereco(id_endereco)
);

CREATE TABLE IF NOT EXISTS tb_empresa_contato(
	id_empresa				INT,
	id_contato				INT,
	PRIMARY KEY(id_empresa, id_contato),
	FOREIGN KEY (id_empresa)			REFERENCES tb_empresa(id_empresa),
	FOREIGN KEY (id_contato)			REFERENCES tb_contato(id_contato)
);

CREATE TABLE IF NOT EXISTS tb_role(
	id_role						INT AUTO_INCREMENT PRIMARY KEY,
    descricao					VARCHAR(50),
    ativo						BOOLEAN DEFAULT TRUE,
    excluido					BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS tb_modulo(
	id_modulo					INT AUTO_INCREMENT PRIMARY KEY,
    id_role						INT,
    descricao					ENUM('COMPRAS', 'VENDAS', 'FINANCEIRO', 'CONFIG', 'FATURAMENTO', 'EXPEDICAO', 'CRIACAO', 'CONTABILIDADE', 'PCP'),
    excluido					BOOLEAN DEFAULT FALSE,
	FOREIGN KEY(id_role)		REFERENCES tb_role(id_role)
);

CREATE TABLE IF NOT EXISTS tb_permissao(
	id_permissao				INT AUTO_INCREMENT PRIMARY KEY,
    id_modulo					INT,
    descricao					ENUM('VISUALIZAR', 'EDITAR', 'CRIAR', 'EXCLUIR'),
    excluido					BOOLEAN DEFAULT FALSE,
	FOREIGN KEY(id_modulo)		REFERENCES tb_modulo(id_modulo)
);

CREATE TABLE IF NOT EXISTS tb_usuario(
	id_usuario					INT AUTO_INCREMENT PRIMARY KEY,
    id_role						INT NOT NULL,
    id_empresa					INT NOT NULL,
	senha						VARCHAR(20) NOT NULL,
	login						VARCHAR(20) NOT NULL,
	ativo						BOOLEAN DEFAULT TRUE,
	excluido					BOOLEAN DEFAULT FALSE,
    FOREIGN KEY(id_empresa)		REFERENCES tb_empresa(id_empresa),
    FOREIGN KEY(id_role)		REFERENCES tb_role(id_role)
);

INSERT INTO tb_role(descricao)	VALUES('ADMINISTRADOR');

INSERT INTO tb_modulo(id_role, descricao) VALUES(1,'VENDAS');
INSERT INTO tb_modulo(id_role, descricao) VALUES(1,'COMPRAS');
INSERT INTO tb_modulo(id_role, descricao) VALUES(1,'FINANCEIRO');
INSERT INTO tb_modulo(id_role, descricao) VALUES(1,'CONFIG');
INSERT INTO tb_modulo(id_role, descricao) VALUES(1,'FATURAMENTO');
INSERT INTO tb_modulo(id_role, descricao) VALUES(1,'EXPEDICAO');
INSERT INTO tb_modulo(id_role, descricao) VALUES(1,'CRIACAO');
INSERT INTO tb_modulo(id_role, descricao) VALUES(1,'PCP');
INSERT INTO tb_modulo(id_role, descricao) VALUES(1,'CONTABILIDADE');

INSERT INTO tb_permissao(id_modulo, descricao) VALUES(1, 'VISUALIZAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(1, 'EDITAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(1, 'CRIAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(1, 'EXCLUIR');

INSERT INTO tb_permissao(id_modulo, descricao) VALUES(2, 'VISUALIZAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(2, 'EDITAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(2, 'CRIAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(2, 'EXCLUIR');

INSERT INTO tb_permissao(id_modulo, descricao) VALUES(3, 'VISUALIZAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(3, 'EDITAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(3, 'CRIAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(3, 'EXCLUIR');

INSERT INTO tb_permissao(id_modulo, descricao) VALUES(4, 'VISUALIZAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(4, 'EDITAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(4, 'CRIAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(4, 'EXCLUIR');

INSERT INTO tb_permissao(id_modulo, descricao) VALUES(5, 'VISUALIZAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(5, 'EDITAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(5, 'CRIAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(5, 'EXCLUIR');

INSERT INTO tb_permissao(id_modulo, descricao) VALUES(6, 'VISUALIZAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(6, 'EDITAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(6, 'CRIAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(6, 'EXCLUIR');

INSERT INTO tb_permissao(id_modulo, descricao) VALUES(7, 'VISUALIZAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(7, 'EDITAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(7, 'CRIAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(7, 'EXCLUIR');

INSERT INTO tb_permissao(id_modulo, descricao) VALUES(8, 'VISUALIZAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(8, 'EDITAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(8, 'CRIAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(8, 'EXCLUIR');

INSERT INTO tb_permissao(id_modulo, descricao) VALUES(9, 'VISUALIZAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(9, 'EDITAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(9, 'CRIAR');
INSERT INTO tb_permissao(id_modulo, descricao) VALUES(9, 'EXCLUIR');

CREATE TABLE IF NOT EXISTS tb_grupo_fornecedor(
	id_grupo_fornecedor 	INT AUTO_INCREMENT PRIMARY KEY,
	descricao 				VARCHAR(50),
	ativo					BOOLEAN,
    excluido				BOOLEAN DEFAULT FALSE
);


CREATE TABLE IF NOT EXISTS tb_grupo_solicitante(
	id_grupo_solicitante 	INT AUTO_INCREMENT PRIMARY KEY,
	descricao 				VARCHAR(50),
	ativo					BOOLEAN,
    excluido				BOOLEAN DEFAULT FALSE
);

-- Tipo de Fornecedor
-- Mapeada

CREATE TABLE IF NOT EXISTS tb_tipo_fornecedor(
	id_tipo_fornecedor 		INT AUTO_INCREMENT PRIMARY KEY,
	descricao 				VARCHAR(50),
	ativo					BOOLEAN,
    excluido				BOOLEAN DEFAULT FALSE
);

-- Forma de Pagamento
-- Mapeada

CREATE TABLE IF NOT EXISTS tb_forma_pagamento(
	id_forma_pagamento 		INT AUTO_INCREMENT PRIMARY KEY,
	descricao 				VARCHAR(50),
	ativo					BOOLEAN,
    excluido				BOOLEAN DEFAULT FALSE
);

-- Endereço
-- Mapeada

CREATE TABLE IF NOT EXISTS tb_endereco(
	id_endereco 			INT AUTO_INCREMENT PRIMARY KEY,
	estado 					VARCHAR(50),
	bairro 					VARCHAR(50),
	endereco 				VARCHAR(50),
	complemento 			VARCHAR(50),
	municipio 				VARCHAR(50),
	numero 					INT,
	cep 					INT,
    excluido				BOOLEAN DEFAULT FALSE
);

-- Tipo Produto
-- Mapeado

CREATE TABLE IF NOT EXISTS tb_tipo_produto(
	id_tipo_produto 			INT AUTO_INCREMENT PRIMARY KEY,
	descricao 					VARCHAR(100),
	ativo						BOOLEAN,
    excluido					BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS tb_estoque(
	id_estoque 			INT AUTO_INCREMENT PRIMARY KEY,
	descricao 					VARCHAR(100),
    excluido					BOOLEAN DEFAULT FALSE
);

-- Grupo Produto
-- Mapeado

CREATE TABLE IF NOT EXISTS tb_grupo_produto(
	id_grupo_produto 			INT AUTO_INCREMENT PRIMARY KEY,
	descricao 					VARCHAR(100),
	ativo						BOOLEAN,
    excluido					BOOLEAN DEFAULT FALSE
);

-- Modelo
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_modelo(
	id_modelo					INT AUTO_INCREMENT PRIMARY KEY,
	descricao					VARCHAR(50),
    excluido					BOOLEAN DEFAULT FALSE
);

-- Cores
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_cor(
	id_cor					INT AUTO_INCREMENT PRIMARY KEY,
	descricao				VARCHAR(50),
	ativo					BOOLEAN,
    excluido				BOOLEAN DEFAULT FALSE
);

-- Sub-grupos
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_subgrupo_produto(
	id_subgrupo_produto		INT AUTO_INCREMENT PRIMARY KEY,
	id_grupo_produto		INT,
	descricao				VARCHAR(50),
	ativo					BOOLEAN,
    excluido				BOOLEAN DEFAULT FALSE,
	FOREIGN KEY(id_grupo_produto)		REFERENCES tb_grupo_produto(id_grupo_produto)
);

-- Regiões
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_regiao(
	id_regiao				INT AUTO_INCREMENT PRIMARY KEY,
	descricao				VARCHAR(50),
    excluido				BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS tb_regiao(
	id_regiao				INT AUTO_INCREMENT PRIMARY KEY,
	descricao				VARCHAR(50),
    excluido				BOOLEAN DEFAULT FALSE
);


-- Zonas
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_zona(
	id_zona					INT AUTO_INCREMENT PRIMARY KEY,
	id_regiao				INT,
	descricao				VARCHAR(50),
    excluido				BOOLEAN DEFAULT FALSE,
	FOREIGN KEY(id_regiao)				REFERENCES tb_regiao(id_regiao)
);

-- Faixas de Cep
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_faixa_cep(
	id_faixa_cep			INT AUTO_INCREMENT PRIMARY KEY,
	comissao				DECIMAL(10,2),
	desconto				DECIMAL(10,2),
	cep_inicial				VARCHAR(10),
	cep_final				VARCHAR(10),
    excluido				BOOLEAN DEFAULT FALSE
);

-- Setores
-- Mapeado

CREATE TABLE IF NOT EXISTS tb_setor(
	id_setor				INT AUTO_INCREMENT PRIMARY KEY,
	id_zona					INT,
	id_faixa_cep			INT,
	descricao				VARCHAR(50),
	ativo					BOOLEAN,
	excluido				BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (id_zona)				REFERENCES tb_zona(id_zona),
	FOREIGN KEY (id_faixa_cep)			REFERENCES tb_faixa_cep(id_faixa_cep)
);


-- Marcas
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_marca(
	id_marca				INT AUTO_INCREMENT PRIMARY KEY,
	descricao				VARCHAR(50),
	ativo					BOOLEAN,
    excluido				BOOLEAN DEFAULT FALSE
);

-- Colecao
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_colecao(
	id_colecao				INT AUTO_INCREMENT PRIMARY KEY,
	descricao				VARCHAR(50),
	quantidade_prevista		INT,
	data_inicio_colecao		DATE,
	data_fim_colecao		DATE,
	data_inicio_producao	DATE,
	data_fim_producao		DATE,
	data_inicio_vendas		DATE,
	data_fim_vendas			DATE,
	quantidade_vendida		INT,
	ativo					BOOLEAN,
    excluido				BOOLEAN DEFAULT FALSE
);

-- Segmentos
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_segmento(
	id_segmento				INT AUTO_INCREMENT PRIMARY KEY,
	descricao				VARCHAR(50),
	ativo					BOOLEAN,
    excluido				BOOLEAN DEFAULT FALSE
);

-- Lote Produção
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_lote_producao(
	id_lote_producao		INT AUTO_INCREMENT PRIMARY KEY,
	descricaocd 				VARCHAR(50),
	data_inicio				DATE,
	data_final				DATE,
	quantidade_lote			INT,
	permite_pedido			BOOLEAN,
	permite_vendas			BOOLEAN,
	ativo					BOOLEAN,
    excluido				BOOLEAN DEFAULT FALSE
);

-- Tamanho
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_tamanho(
	id_tamanho				INT AUTO_INCREMENT PRIMARY KEY,
	tamanho					VARCHAR(15),
	descricao				VARCHAR(25),
    excluido				BOOLEAN DEFAULT FALSE
);

-- Preco
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_preco(
	id_preco				INT AUTO_INCREMENT PRIMARY KEY,
	valor					DECIMAL(10,2),
	descricao				VARCHAR(10),
    excluido				BOOLEAN DEFAULT FALSE
);

-- Modelo
-- mapeado
CREATE TABLE IF NOT EXISTS tb_modelo(
	id_modelo				INT AUTO_INCREMENT PRIMARY KEY,
	descricao				VARCHAR(50),
    excluido				BOOLEAN DEFAULT FALSE
);

-- Tipo de Pedido de Venda
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_tipo_pedido_venda(
	id_tipo_pedido_venda	INT AUTO_INCREMENT PRIMARY KEY,
	descricao				VARCHAR(50),
	duplicata				BOOLEAN,
	ativo					BOOLEAN,
    excluido				BOOLEAN DEFAULT FALSE
);

-- Metas
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_meta(
	id_meta					INT AUTO_INCREMENT PRIMARY KEY,
	valor					DECIMAL(10,2),
	quantidade				INT,
	inicio					DATE,
	fim						DATE,
    excluido				BOOLEAN DEFAULT FALSE
);

-- Grade
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_grade(
	id_grade				INT AUTO_INCREMENT PRIMARY KEY,
	id_tamanho				INT,
	id_preco				INT,
	descricao				VARCHAR(50),
	ativo					BOOLEAN,
    excluido				BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (id_tamanho)			REFERENCES tb_tamanho(id_tamanho),
	FOREIGN KEY (id_preco)				REFERENCES tb_preco(id_preco)
);

-- Imagem
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_imagem(
	id_imagem				INT AUTO_INCREMENT PRIMARY KEY,
	descricao				VARCHAR(50),
	formato					VARCHAR(10),
	imagem					BLOB,
    excluido				BOOLEAN DEFAULT FALSE
);

-- Grupo de Cliente
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_grupo_cliente(
	id_grupo_cliente 		INT AUTO_INCREMENT PRIMARY KEY,
	descricao 				VARCHAR(50),
    excluido				BOOLEAN DEFAULT FALSE
);


-- Banco
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_banco(
	id_banco 				INT AUTO_INCREMENT PRIMARY KEY,
	numero_banco 			VARCHAR(15),
	agencia 				VARCHAR(15),
	conta 					VARCHAR(15),
	saldo 					DECIMAL(10,2),
	data_inclusao 			DATE,
    excluido				BOOLEAN DEFAULT FALSE
);

-- Natureza
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_natureza(
	id_natureza				INT AUTO_INCREMENT PRIMARY KEY,
	id_conta_contabil		INT,
	descricao				VARCHAR(50),
	tipo_debito_credito		VARCHAR(50),
    excluido				BOOLEAN DEFAULT FALSE
);

-- Tipo de Lançamento
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_tipo_lancamento(
	id_tipo_lancamento		INT AUTO_INCREMENT PRIMARY KEY,
	descricao				VARCHAR(50),
	tipo					VARCHAR(50),
    excluido				BOOLEAN DEFAULT FALSE
);

-- Condição de Pagamento
-- mapeado

CREATE TABLE IF NOT EXISTS tb_condicao_pagamento(
	id_condicao_pagamento	INT AUTO_INCREMENT PRIMARY KEY,
	descricao 				VARCHAR(45),
	juros 					DECIMAL(10,2),
	desconto 				DECIMAL(10,2),
	prazo_medio				INT,
	quantidade_vezes		INT,
	contas_pagar_receber	VARCHAR(1),
    excluido				BOOLEAN DEFAULT FALSE	
);

CREATE TABLE IF NOT EXISTS tb_dias_parcelas(
	id_dias_parcelas		INT AUTO_INCREMENT PRIMARY KEY,
	id_condicao_pagamento	INT,
	descricao				INT,
	excluido				BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (id_condicao_pagamento)	REFERENCES tb_condicao_pagamento(id_condicao_pagamento)
);

-- FIM TABELAS BASE

-- Produto
-- Mapeado

CREATE TABLE IF NOT EXISTS tb_produto(
	id_produto 					INT AUTO_INCREMENT PRIMARY KEY,
	id_tipo_produto 			INT,
	id_grupo_produto 			INT,
	id_conta_contabil 			INT,
	id_subgrupo_produto			INT,
	descricao 					VARCHAR(100),
	unidade_medida 				VARCHAR(20),
	unidade_medida2 			VARCHAR(20),
	conversor_abudade			ENUM('MULTIPLICAR', 'DIVIDIR', 'SOMAR', 'SUBTRAIR'),
	fator_conversor				DECIMAL(10,2),
	codigo_barras_fornecedor 	VARCHAR(50),
	codigo_barras 				VARCHAR(50),
	peso 						DECIMAL(10,2),
	altura 						DECIMAL(10,2),
	largura 					DECIMAL(10,2),
	quantidade_max				DECIMAL(10,2) DEFAULT 0,
	quantidade_min				DECIMAL(10,2) DEFAULT 0,
	ponto_pedido				DECIMAL(10,2) DEFAULT 0,
	lote_economico				DECIMAL(10,2) DEFAULT 0,
	data_ultima_compra 			DATE,
	pontuacao 					DECIMAL(10,2),
    calculo_valor				ENUM('MEDIO', 'MAIOR_VALOR', 'MENOR_VALOR'),
	valor 						DECIMAL(10,2),
    excluido					BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (id_subgrupo_produto)	REFERENCES tb_subgrupo_produto(id_subgrupo_produto),
	FOREIGN KEY (id_tipo_produto) 		REFERENCES tb_tipo_produto(id_tipo_produto),
	FOREIGN KEY (id_grupo_produto) 		REFERENCES tb_grupo_produto(id_grupo_produto)
);

-- Produto e Cor MxN
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_produto_cor(
	id_produto 				INT,
	id_cor					INT,
	PRIMARY KEY(id_produto, id_cor),
	FOREIGN KEY (id_produto)		REFERENCES tb_produto(id_produto),
	FOREIGN KEY (id_cor)			REFERENCES tb_cor(id_cor)
);

-- Fornecedor
-- Mapeada

CREATE TABLE IF NOT EXISTS tb_fornecedor(
	id_fornecedor 			INT AUTO_INCREMENT PRIMARY KEY,
	id_grupo_fornecedor 	INT,
	id_endereco				INT,
	id_tipo_fornecedor 		INT,
	razao_social 			VARCHAR(50),
	nome_fantasia 			VARCHAR(50),
	cnpj	 				VARCHAR(50),
	cpf						VARCHAR(50),
	inscricao_estadual 		VARCHAR(50),
	data_ultima_compra 		DATE,
	pontuacao 				DECIMAL(10,2),
	telefone_fixo 			VARCHAR(15),
	celular 				VARCHAR(15),
    excluido				BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (id_grupo_fornecedor) 	REFERENCES tb_grupo_fornecedor(id_grupo_fornecedor),
	FOREIGN KEY (id_tipo_fornecedor) 	REFERENCES tb_tipo_fornecedor(id_tipo_fornecedor),
	FOREIGN KEY (id_endereco) 			REFERENCES tb_endereco(id_endereco)
);

CREATE TABLE IF NOT EXISTS tb_fornecedor_contato(
	id_fornecedor			INT,
	id_contato				INT,
	PRIMARY KEY(id_fornecedor, id_contato),
	FOREIGN KEY (id_fornecedor)			REFERENCES tb_fornecedor(id_fornecedor),
	FOREIGN KEY (id_contato)			REFERENCES tb_contato(id_contato)
);

CREATE TABLE IF NOT EXISTS tb_solicitante(
	id_solicitante			INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario				INT,
    id_grupo_produto		INT,
    id_grupo_solicitante	INT,
    data_inicio				DATE,
    data_fim				DATE,
    limite_inicio			DECIMAL(10,2),
    limite_fim				DECIMAL(10,2),
    valor_disponivel		DECIMAL(10,2),
    nivel					INT,
	ativo					BOOLEAN DEFAULT TRUE,
    excluido				BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (id_usuario)			REFERENCES tb_usuario(id_usuario),
	FOREIGN KEY (id_grupo_produto)		REFERENCES tb_grupo_produto(id_grupo_produto),
	FOREIGN KEY (id_grupo_solicitante)	REFERENCES tb_grupo_solicitante(id_grupo_solicitante)
);

-- Pedido de Compra
-- mapeada

CREATE TABLE IF NOT EXISTS tb_pedido_compra(
	id_pedido_compra		INT AUTO_INCREMENT PRIMARY KEY,
	id_fornecedor			INT,
	id_condicao_pagamento	INT,
	id_forma_pagamento		INT,
	id_conta_contabil		INT,
    id_solicitante			INT,
	sif_fob 				VARCHAR(1),
	valor_frete				DECIMAL(10,2),
	data_prevista_entrega	DATE,
	quantidade_produto		INT,
	valor_total				DECIMAL(10,2),
	situacao				ENUM('SOLICITADO','LIBERADO', 'PARCIALMENTE_LIBERADO', 'NEGADO', 'ENTREGUE', 'PARCIALMENTE_ENTREGUE'),
	data_solicitacao		DATE,
	data_entrega			DATE,
    excluido				BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (id_solicitante) 				REFERENCES tb_solicitante(id_solicitante),
	FOREIGN KEY (id_fornecedor) 				REFERENCES tb_fornecedor(id_fornecedor),
	FOREIGN KEY	(id_condicao_pagamento) 		REFERENCES tb_condicao_pagamento(id_condicao_pagamento),
	FOREIGN KEY (id_forma_pagamento)			REFERENCES tb_forma_pagamento(id_forma_pagamento)
);

CREATE TABLE IF NOT EXISTS tb_produto_fornecedor(
	id_produto 				INT,
	id_fornecedor 			INT,
	PRIMARY KEY(id_produto, id_fornecedor),
	FOREIGN KEY(id_produto) 			REFERENCES tb_produto(id_produto),
	FOREIGN KEY(id_fornecedor) 			REFERENCES tb_fornecedor(id_fornecedor)
);

CREATE TABLE IF NOT EXISTS tb_liberador(
	id_liberador			INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario				INT,
    id_grupo_produto		INT,
    id_grupo_solicitante	INT,
    data_inicio				DATE,
    data_fim				DATE,
    limite_inicio			DECIMAL(10,2),
    limite_fim				DECIMAL(10,2),
    valor_disponivel		DECIMAL(10,2),
    nivel					INT,
	ativo					BOOLEAN DEFAULT TRUE,
    excluido				BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (id_usuario)			REFERENCES tb_usuario(id_usuario),
	FOREIGN KEY (id_grupo_produto)		REFERENCES tb_grupo_produto(id_grupo_produto),
	FOREIGN KEY (id_grupo_solicitante)	REFERENCES tb_grupo_solicitante(id_grupo_solicitante)
);

CREATE TABLE IF NOT EXISTS tb_item_pedido_compra(
	id_item_pedido_compra	INT AUTO_INCREMENT,
	id_pedido_compra 		INT,
	id_produto 				INT,
    id_cor					INT,
    id_liberador			INT,
    id_solicitante			INT,
    situacao				ENUM('SOLICITADO','LIBERADO', 'PARCIALMENTE_LIBERADO', 'NEGADO', 'ENTREGUE', 'PARCIALMENTE_ENTREGUE'),
    nivel					INT,
    quantidade				DECIMAL(10,2),
	valor					DECIMAL(10,2),
    data_situacao			DATE,
    excluido 				BOOLEAN DEFAULT FALSE,
	PRIMARY KEY(id_item_pedido_compra),
	FOREIGN KEY(id_produto) 			REFERENCES tb_produto(id_produto),
	FOREIGN KEY(id_pedido_compra) 		REFERENCES tb_pedido_compra(id_pedido_compra),
    FOREIGN KEY(id_cor)			 		REFERENCES tb_cor(id_cor),
    FOREIGN KEY(id_liberador)			REFERENCES tb_liberador(id_liberador),
    FOREIGN KEY(id_solicitante) 		REFERENCES tb_solicitante(id_solicitante)
);

CREATE TABLE IF NOT EXISTS tb_item_autorizado(
	id_item_autorizado	INT AUTO_INCREMENT PRIMARY KEY,
    id_item_pedido_compra	INT,
    id_liberador			INT,
    data_liberacao			INT,
    situacao				VARCHAR(45),
    excluido				BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (id_item_pedido_compra)	REFERENCES tb_item_pedido_compra(id_item_pedido_compra),
    FOREIGN KEY (id_liberador)			REFERENCES tb_liberador(id_liberador)
);

-- Representantes
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_representante(
	id_representante		INT AUTO_INCREMENT PRIMARY KEY,
	id_endereco				INT,
	id_imagem				INT,-- INICIO
	id_centro_custo			INT,
	id_conta_contabil		INT,
	id_setor				INT,
	razao_social 			VARCHAR(50),
	nome_fantasia 			VARCHAR(50),
	tipo_contribuinte		VARCHAR(50),
	cnpj 					VARCHAR(50),
	cpf						VARCHAR(50),
	inscricao_estadual 		VARCHAR(50),
	percentual_comissao		DECIMAL(10,2),
	telefone_fixo 			VARCHAR(15),
	celular 				VARCHAR(15),
	email_contato			VARCHAR(50),
	email_envio_xml			VARCHAR(50),
	ativo					BOOLEAN,
    excluido				BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (id_imagem)				REFERENCES tb_imagem(id_imagem),
	FOREIGN KEY (id_setor)				REFERENCES tb_setor(id_setor),
	FOREIGN KEY (id_endereco) 			REFERENCES tb_endereco(id_endereco)
);

CREATE TABLE IF NOT EXISTS tb_representante_contato(
	id_representante		INT,
	id_contato				INT,
	PRIMARY KEY(id_representante, id_contato),
	FOREIGN KEY (id_representante)		REFERENCES tb_representante(id_representante),
	FOREIGN KEY (id_contato)			REFERENCES tb_contato(id_contato)
);


-- Cliente
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_cliente(
	id_cliente 				INT AUTO_INCREMENT PRIMARY KEY,
	id_grupo_cliente 		INT,
	id_endereco				INT,
	id_imagem				INT,
	id_setor				INT,
	id_representante		INT,
	razao_social 			VARCHAR(50),
	nome_fantasia 			VARCHAR(50),
	cnpj 					VARCHAR(50),
	cpf						VARCHAR(50),
	inscricao_estadual 		INT,
	data_ultima_compra 		DATE,
	consumidor_final		VARCHAR(50),
	bloqueado_inativo		BOOLEAN,
	bloquear_vendas			BOOLEAN,
	bloquear_faturamento	BOOLEAN,
	pontuacao 				DECIMAL(10,2),
	telefone_fixo 			VARCHAR(15),
	celular 				VARCHAR(15),
	email_contato			VARCHAR(50),
	email_envio_xml			VARCHAR(50),
    excluido				BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (id_imagem)				REFERENCES tb_imagem(id_imagem),
	FOREIGN KEY (id_setor)				REFERENCES tb_setor(id_setor),
	FOREIGN KEY (id_representante)		REFERENCES tb_representante(id_representante),
	FOREIGN KEY (id_grupo_cliente) 		REFERENCES tb_grupo_cliente(id_grupo_cliente),
	FOREIGN KEY (id_endereco) 			REFERENCES tb_endereco(id_endereco)
);

CREATE TABLE IF NOT EXISTS tb_cliente_contato(
	id_cliente				INT,
	id_contato				INT,
	PRIMARY KEY(id_cliente, id_contato),
	FOREIGN KEY (id_cliente)			REFERENCES tb_cliente(id_cliente),
	FOREIGN KEY (id_contato)			REFERENCES tb_contato(id_contato)
);

-- Titulo a receber
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_titulo_receber(
	id_titulo_receber		INT AUTO_INCREMENT PRIMARY KEY,
	id_cliente				INT,
	id_condicao_pagamento	INT,
	id_forma_pagamento		INT,	
	id_tipo_lancamento		INT,
	id_conta_contabil		INT,
	data_inclusao			DATE,
	data_lancamento			DATE,
	valor_total				DECIMAL(10,2),
    excluido				BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (id_cliente)			REFERENCES tb_cliente(id_cliente),
	FOREIGN KEY	(id_condicao_pagamento) REFERENCES tb_condicao_pagamento(id_condicao_pagamento),
	FOREIGN KEY (id_forma_pagamento)	REFERENCES tb_forma_pagamento(id_forma_pagamento),
	FOREIGN KEY (id_tipo_lancamento)	REFERENCES tb_tipo_lancamento(id_tipo_lancamento)
);

-- Titulo a pagar
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_titulo_pagar(
	id_titulo_pagar			INT AUTO_INCREMENT PRIMARY KEY,
	id_fornecedor			INT,
	id_condicao_pagamento	INT,
	id_forma_pagamento		INT,
	id_tipo_lancamento		INT,
	id_conta_contabil		INT,
	data_inclusao			DATE,
	data_lancamento			DATE,
	numero_parcelas			INT,
	valor_total				DECIMAL(10,2),
	percentual_desconto		DECIMAL(10,2),
	percentual_juros		DECIMAL(10,2),
    excluido				BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (id_fornecedor)			REFERENCES tb_fornecedor(id_fornecedor),
	FOREIGN KEY	(id_condicao_pagamento) REFERENCES tb_condicao_pagamento(id_condicao_pagamento),
	FOREIGN KEY (id_forma_pagamento)	REFERENCES tb_forma_pagamento(id_forma_pagamento),
	FOREIGN KEY (id_tipo_lancamento)	REFERENCES tb_tipo_lancamento(id_tipo_lancamento)
);

-- Parcela a Receber
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_parcela_receber(
	id_parcela_receber		INT AUTO_INCREMENT PRIMARY KEY,
	id_titulo_receber		INT,
	parcela					VARCHAR(10),
	date_vencimento			DATE,
	valor_original			DECIMAL(10,2),
	valor_pagar				DECIMAL(10,2),
	percentual_desconto		DECIMAL(10,2),
	valor_desconto			DECIMAL(10,2),
	percentual_juro			DECIMAL(10,2),
	valor_juro				DECIMAL(10,2),
    excluido				BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (id_titulo_receber)		REFERENCES tb_titulo_receber(id_titulo_receber)
);

-- Parcela a Pagar
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_parcela_pagar(
	id_parcela_pagar		INT AUTO_INCREMENT PRIMARY KEY,
	id_titulo_pagar			INT,
	parcela					VARCHAR(10),
	date_vencimento			DATE,
	valor_original			DECIMAL(10,2),
	valor_pagar				DECIMAL(10,2),
	percentual_desconto		DECIMAL(10,2),
	valor_desconto			DECIMAL(10,2),
	percentual_juro			DECIMAL(10,2),
	valor_juro				DECIMAL(10,2),
    excluido				BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (id_titulo_pagar)		REFERENCES tb_titulo_pagar(id_titulo_pagar)
);

-- Baixa
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_baixa(
	id_baixa				INT AUTO_INCREMENT PRIMARY KEY,
	id_natureza				INT,
	id_tipo_lancamento		INT,
	id_conta_contabil		INT,
	data_baixa				DATE,
	valor_baixa				DECIMAL(10,2),
	decressimo				DECIMAL(10,2),
	dias_atraso				INT,
	tipo_pagar_receber		VARCHAR(10),
    excluido				BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (id_natureza)			REFERENCES tb_natureza(id_natureza),
	FOREIGN KEY (id_tipo_lancamento)	REFERENCES tb_tipo_lancamento(id_tipo_lancamento)
);

-- Baixa de Parcela a Receber MxN
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_baixa_parcela_receber(
	id_baixa				INT,
	id_parcela_receber		INT,
	PRIMARY KEY				(id_baixa, id_parcela_receber),
	FOREIGN KEY (id_baixa)				REFERENCES tb_baixa(id_baixa),
	FOREIGN KEY (id_parcela_receber)	REFERENCES tb_parcela_receber(id_parcela_receber)
);

-- Baixa de Parcela a Pagar MxN
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_baixa_parcela_pagar(
	id_baixa				INT,
	id_parcela_pagar		INT,
	PRIMARY KEY				(id_baixa, id_parcela_pagar),
	FOREIGN KEY (id_baixa)				REFERENCES tb_baixa(id_baixa),
	FOREIGN KEY (id_parcela_pagar)		REFERENCES tb_parcela_pagar(id_parcela_pagar)
);

-- Movimentação Bancaria
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_movimentacao_bancaria(
	id_movimentacao_bancaria INT AUTO_INCREMENT PRIMARY KEY,
	id_banco				 INT,
	id_conta_contabil		 INT,
	data_movimentacao		 DATE,
	descricao				 VARCHAR(50),
	valor					 DECIMAL(10,2),
	saldo_final				 DECIMAL(10,2),
	debito_credito			 VARCHAR(5),
    excluido				BOOLEAN DEFAULT FALSE
);

-- Baixa e Movimentação Bancaria MxN
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_movimentacao_bancaria_baixa(
	id_baixa				 INT,
	id_movimentacao_bancaria INT,
	PRIMARY KEY (id_baixa, id_movimentacao_bancaria),
	FOREIGN KEY (id_baixa)					REFERENCES tb_baixa(id_baixa),
	FOREIGN KEY (id_movimentacao_bancaria)	REFERENCES tb_movimentacao_bancaria(id_movimentacao_bancaria)
);

-- Renegociação de Titulo a receber
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_renegociacao_receber(
	id_renegociacao_receber	INT AUTO_INCREMENT PRIMARY KEY,
	id_titulo_receber		INT,
	id_condicao_pagamento	INT,
	id_forma_pagamento		INT,
	id_tipo_lancamento		INT,
	id_natureza				INT,
	data_negociacao			DATE,
	valor_original			DECIMAL(10,2),
	valor_renegociado		DECIMAL(10,2),
    excluido				BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (id_titulo_receber)			REFERENCES tb_titulo_receber(id_titulo_receber),
	FOREIGN KEY (id_condicao_pagamento)		REFERENCES tb_condicao_pagamento(id_condicao_pagamento),
	FOREIGN KEY (id_forma_pagamento)		REFERENCES tb_forma_pagamento(id_forma_pagamento),
	FOREIGN KEY (id_tipo_lancamento)		REFERENCES tb_tipo_lancamento(id_tipo_lancamento),
	FOREIGN KEY (id_natureza)				REFERENCES tb_natureza(id_natureza)
);

-- Renegociação de Titulo a Pagar
--  Mapeado
CREATE TABLE IF NOT EXISTS tb_renegociacao_pagar(
	id_renegociacao_pagar	INT AUTO_INCREMENT PRIMARY KEY,
	id_fornecedor			INT,
	id_titulo_pagar			INT,
	id_condicao_pagamento	INT,
	id_forma_pagamento		INT,
	id_tipo_lancamento		INT,
	id_natureza				INT,
	data_negociacao			DATE,
	valor_original			DECIMAL(10,2),
	valor_renegociado		DECIMAL(10,2),
    excluido				BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (id_fornecedor)				REFERENCES tb_fornecedor(id_fornecedor),
	FOREIGN KEY (id_titulo_pagar)			REFERENCES tb_titulo_pagar(id_titulo_pagar),
	FOREIGN KEY (id_condicao_pagamento)		REFERENCES tb_condicao_pagamento(id_condicao_pagamento),
	FOREIGN KEY (id_forma_pagamento)		REFERENCES tb_forma_pagamento(id_forma_pagamento),
	FOREIGN KEY (id_tipo_lancamento)		REFERENCES tb_tipo_lancamento(id_tipo_lancamento),
	FOREIGN KEY (id_natureza)				REFERENCES tb_natureza(id_natureza)
);

-- Compensação de Titulo
-- Mapeado
CREATE TABLE IF NOT EXISTS tb_compensacao(
	id_compensacao			INT AUTO_INCREMENT PRIMARY KEY,
	id_cliente				INT,
	id_fornecedor			INT,
	id_baixa				INT,
	data_compensacao		DATE,
    excluido				BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (id_cliente)				REFERENCES tb_cliente(id_cliente),
	FOREIGN KEY (id_fornecedor)				REFERENCES tb_fornecedor(id_fornecedor),
	FOREIGN KEY (id_baixa)					REFERENCES tb_baixa(id_baixa)
);

-- FIM financeiro
-- INICIO vendas


-- Transportadora

CREATE TABLE IF NOT EXISTS tb_transportadora(
	id_transportadora		INT AUTO_INCREMENT PRIMARY KEY,
	id_endereco				INT,
	razao_social 			VARCHAR(50),
	nome_fantasia 			VARCHAR(50),
	cnpj	 				VARCHAR(50),
	cpf						VARCHAR(50),
	inscricao_estadual 		VARCHAR(50),
	email_contato			INT,
	pontuacao 				DECIMAL(10,2),
	telefone_fixo 			VARCHAR(15),
	celular 				VARCHAR(15),
    excluido				BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (id_endereco) 			REFERENCES tb_endereco(id_endereco)
);

CREATE TABLE IF NOT EXISTS tb_transportadora_contato(
	id_transportadora		INT,
	id_contato				INT,
	PRIMARY KEY(id_transportadora, id_contato),
	FOREIGN KEY (id_transportadora)		REFERENCES tb_transportadora(id_transportadora),
	FOREIGN KEY (id_contato)			REFERENCES tb_contato(id_contato)
);

-- Regra de negócio
-- Verificar Mapeado
CREATE TABLE IF NOT EXISTS tb_regra_negocio(
	id_regra_negocio		INT AUTO_INCREMENT PRIMARY KEY,
	percentual_comissao		DECIMAL(10,2),
	preco_one				DECIMAL(10,2),
	preco_two				DECIMAL(10,2),
	preco_three				DECIMAL(10,2),
	desconto_referencia		DECIMAL(10,2),
	comissao_referencia		DECIMAL(10,2),
	ativo					BOOLEAN,
    excluido				BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS tb_tabela_preco(
	id_tabela_preco			INT AUTO_INCREMENT PRIMARY KEY,
	id_regra_negocio		INT,
	data_inicio				DATE,
	data_fim				DATE,
	quantidade_minima		INT,
	quantidade_maxima		INT,
	valor_minimo			DECIMAL(10,2),
	valor_maximo			DECIMAL(10,2),
	descricao				VARCHAR(50),
	ativo					BOOLEAN,
    excluido				BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (id_regra_negocio)		REFERENCES tb_regra_negocio (id_regra_negocio)
);

CREATE TABLE IF NOT EXISTS tb_tabela_preco_setor(
	id_tabela_preco			INT,
	id_setor				INT,
	PRIMARY KEY	(id_tabela_preco, id_setor),
	FOREIGN KEY (id_tabela_preco)		REFERENCES tb_tabela_preco(id_tabela_preco),
	FOREIGN KEY (id_setor)				REFERENCES tb_setor(id_setor)
);

CREATE TABLE IF NOT EXISTS tb_tabela_preco_zona(
	id_tabela_preco			INT,
	id_zona					INT,
	PRIMARY KEY	(id_tabela_preco, id_zona),
	FOREIGN KEY (id_tabela_preco)		REFERENCES tb_tabela_preco(id_tabela_preco),
	FOREIGN KEY (id_zona)				REFERENCES tb_zona(id_zona)
);

CREATE TABLE IF NOT EXISTS tb_tabela_preco_regiao(
	id_tabela_preco			INT,
	id_regiao				INT,
	PRIMARY KEY	(id_tabela_preco, id_regiao),
	FOREIGN KEY (id_tabela_preco)		REFERENCES tb_tabela_preco(id_tabela_preco),
	FOREIGN KEY (id_regiao)				REFERENCES tb_regiao(id_regiao)
);

CREATE TABLE IF NOT EXISTS tb_tabela_preco_representante(
	id_tabela_preco			INT,
	id_representante		INT,
	PRIMARY KEY	(id_tabela_preco, id_representante),
	FOREIGN KEY (id_tabela_preco)		REFERENCES tb_tabela_preco(id_tabela_preco),
	FOREIGN KEY (id_representante)		REFERENCES tb_representante(id_representante)
);

-- Referencia

CREATE TABLE IF NOT EXISTS tb_referencia(
	id_referencia				INT AUTO_INCREMENT PRIMARY KEY,
	id_tipo_produto 			INT,
	id_grupo_produto 			INT,
	id_conta_contabil 			INT,
	id_subgrupo_produto			INT,
	id_colecao					INT,
	id_marca					INT,
	id_segmento					INT,
	id_grade					INT,
	id_modelo					INT,
	id_imagem					INT,
	data_validade_inicio		DATE,
	data_validade_fim			DATE,
	descricao 					VARCHAR(100),
	unidade_medida 				INT,
	unidade_medida2 			INT,
	conversor_abudade			VARCHAR(10),
	fator_conversor				VARCHAR(10),
	codigo_barras 				INT,
	peso 						DECIMAL(10,2),
	altura 						DECIMAL(10,2),
	largura 					DECIMAL(10,2),
	data_ultima_compra 			DATE,
	pontuacao 					DECIMAL(10,2),
	valor 						DECIMAL(10,2),
	ativo						BOOLEAN,
    excluido					BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (id_imagem)				REFERENCES tb_imagem(id_imagem),
	FOREIGN KEY (id_colecao)			REFERENCES tb_colecao(id_colecao),
	FOREIGN KEY	(id_marca)				REFERENCES tb_marca(id_marca),
	FOREIGN KEY (id_segmento)			REFERENCES tb_segmento(id_segmento),
	FOREIGN KEY (id_grade)				REFERENCES tb_grade(id_grade),
	FOREIGN KEY	(id_modelo)				REFERENCES tb_modelo(id_modelo),
	FOREIGN KEY (id_tipo_produto) 		REFERENCES tb_tipo_produto(id_tipo_produto),
	FOREIGN KEY (id_grupo_produto) 		REFERENCES tb_grupo_produto(id_grupo_produto),
	FOREIGN KEY (id_subgrupo_produto) 	REFERENCES tb_subgrupo_produto(id_subgrupo_produto)
);


-- Representante e Meta MxN

CREATE TABLE IF NOT EXISTS tb_referencia_cor(
	id_referencia			INT,
	id_cor					INT,
	PRIMARY KEY (id_referencia, id_cor),
	FOREIGN KEY (id_referencia)		REFERENCES tb_referencia(id_referencia),
	FOREIGN KEY (id_cor)				REFERENCES tb_cor(id_cor)
);



-- Representante e Meta MxN

CREATE TABLE IF NOT EXISTS tb_representante_meta(
	id_representante		INT,
	id_meta					INT,
	PRIMARY KEY (id_representante, id_meta),
	FOREIGN KEY (id_representante)		REFERENCES tb_representante(id_representante),
	FOREIGN KEY (id_meta)				REFERENCES tb_meta(id_meta)
);



-- Referencia e Regra de Negocio MxN

CREATE TABLE IF NOT EXISTS tb_referencia_regra_negocio(
	id_regra_negocio		INT,
	id_referencia			INT,
	PRIMARY KEY (id_regra_negocio, id_referencia),
	FOREIGN KEY (id_regra_negocio)			REFERENCES tb_regra_negocio(id_regra_negocio),
	FOREIGN KEY (id_referencia)				REFERENCES tb_referencia(id_referencia)
);


-- Setor e Regra de Negocio MxN

CREATE TABLE IF NOT EXISTS tb_setor_regra_negocio(
	id_regra_negocio		INT,
	id_setor				INT,
	PRIMARY KEY (id_regra_negocio, id_setor),
	FOREIGN KEY (id_regra_negocio)			REFERENCES tb_regra_negocio(id_regra_negocio),
	FOREIGN KEY (id_setor)					REFERENCES tb_setor(id_setor)
);

-- Zona e Regra de Negocio MxN

CREATE TABLE IF NOT EXISTS tb_zona_regra_negocio(
	id_regra_negocio		INT,
	id_zona					INT,
	PRIMARY KEY (id_regra_negocio, id_zona),
	FOREIGN KEY (id_regra_negocio)			REFERENCES tb_regra_negocio(id_regra_negocio),
	FOREIGN KEY (id_zona)					REFERENCES tb_zona(id_zona)
);


-- Regiao e Regra de Negocio MxN

CREATE TABLE IF NOT EXISTS tb_regiao_regra_negocio(
	id_regra_negocio		INT,
	id_regiao				INT,
	PRIMARY KEY (id_regra_negocio, id_regiao),
	FOREIGN KEY (id_regra_negocio)			REFERENCES tb_regra_negocio(id_regra_negocio),
	FOREIGN KEY (id_regiao)					REFERENCES tb_regiao(id_regiao)
);

-- Cliente e Regra de Negocio MxN

CREATE TABLE IF NOT EXISTS tb_cliente_regra_negocio(
	id_regra_negocio		INT,
	id_cliente				INT,
	PRIMARY KEY (id_regra_negocio, id_cliente),
	FOREIGN KEY (id_regra_negocio)			REFERENCES tb_regra_negocio(id_regra_negocio),
	FOREIGN KEY (id_cliente)				REFERENCES tb_cliente(id_cliente)
);

-- Pedido de Venda

CREATE TABLE IF NOT EXISTS tb_pedido_venda(
	id_pedido_venda			INT AUTO_INCREMENT PRIMARY KEY,
	id_tipo_pedido_venda	INT,
	id_cliente				INT,
	id_representante		INT,
	id_transportadora		INT,
	id_condicao_pagamento	INT,
	id_forma_pagamento		INT,
	id_lote_producao		INT,
	id_marca				INT,
	id_estoque				INT,
	total_pecas				INT,
	prioridade				INT,
	valor_total				DECIMAL(10,2),
	data_digitacao			DATE,
	data_prevista_entrega	DATE,
	data_aprovacao			DATE,
	descricao				VARCHAR(50),
	digitador				VARCHAR(50),
	aprovador				VARCHAR(50),
	tipo_titulo				VARCHAR(50),
	aprovado				BOOLEAN,
	ativo					BOOLEAN,
    excluido				BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (id_estoque)				REFERENCES tb_estoque(id_estoque),
	FOREIGN KEY (id_tipo_pedido_venda)		REFERENCES tb_tipo_pedido_venda(id_tipo_pedido_venda),
	FOREIGN KEY (id_cliente)				REFERENCES tb_cliente(id_cliente),
	FOREIGN KEY (id_representante)			REFERENCES tb_representante(id_representante),
	FOREIGN KEY (id_transportadora)			REFERENCES tb_transportadora(id_transportadora),
	FOREIGN KEY (id_condicao_pagamento)		REFERENCES tb_condicao_pagamento(id_condicao_pagamento),
	FOREIGN KEY (id_forma_pagamento)		REFERENCES tb_forma_pagamento(id_forma_pagamento),
	FOREIGN KEY (id_lote_producao)			REFERENCES tb_lote_producao(id_lote_producao),
	FOREIGN KEY (id_marca)					REFERENCES tb_marca(id_marca)
);

CREATE TABLE IF NOT EXISTS tb_item_pedido_venda(
	id_item_pedido_venda	INT,
	id_pedido_venda 		INT,
	id_referencia 			INT,
    id_cor					INT,
    quantidade				DECIMAL(10,2),
    excluido 				BOOLEAN DEFAULT FALSE,
	PRIMARY KEY(id_item_pedido_venda),
	FOREIGN KEY(id_referencia) 			REFERENCES tb_referencia(id_referencia),
	FOREIGN KEY(id_pedido_venda) 		REFERENCES tb_pedido_venda(id_pedido_venda),
    FOREIGN KEY(id_cor)			 		REFERENCES tb_cor(id_cor)
);

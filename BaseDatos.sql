--
-- PostgreSQL database dump
--

-- Dumped from database version 15.7
-- Dumped by pg_dump version 16.3

-- Started on 2024-09-07 00:33:50

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3357 (class 1262 OID 18631)
-- Name: bancoPruebas; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "bancoPruebas" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';


ALTER DATABASE "bancoPruebas" OWNER TO postgres;

\connect "bancoPruebas"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 18642)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    clienteid integer NOT NULL,
    contrasena character varying(255) NOT NULL,
    estado boolean NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 18641)
-- Name: cliente_clienteid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cliente_clienteid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.cliente_clienteid_seq OWNER TO postgres;

--
-- TOC entry 3358 (class 0 OID 0)
-- Dependencies: 216
-- Name: cliente_clienteid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cliente_clienteid_seq OWNED BY public.cliente.clienteid;


--
-- TOC entry 218 (class 1259 OID 18655)
-- Name: cuenta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cuenta (
    numero_cuenta character varying(20) NOT NULL,
    tipo_cuenta character varying(50) NOT NULL,
    saldo_inicial numeric(15,2) NOT NULL,
    estado boolean NOT NULL,
    id_cliente integer NOT NULL
);


ALTER TABLE public.cuenta OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 18666)
-- Name: movimiento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movimiento (
    id integer NOT NULL,
    fecha timestamp(6) without time zone NOT NULL,
    tipo_movimiento character varying(50) NOT NULL,
    valor numeric(15,2) NOT NULL,
    saldo numeric(15,2) NOT NULL,
    numero_cuenta character varying(20) NOT NULL,
    valor_inicial numeric(15,2)
);


ALTER TABLE public.movimiento OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 18665)
-- Name: movimiento_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.movimiento_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.movimiento_id_seq OWNER TO postgres;

--
-- TOC entry 3359 (class 0 OID 0)
-- Dependencies: 219
-- Name: movimiento_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.movimiento_id_seq OWNED BY public.movimiento.id;


--
-- TOC entry 215 (class 1259 OID 18633)
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.persona (
    id integer NOT NULL,
    nombre character varying(100) NOT NULL,
    genero character varying(10) NOT NULL,
    edad integer NOT NULL,
    identificacion character varying(20) NOT NULL,
    direccion character varying(255) NOT NULL,
    telefono character varying(20) NOT NULL
);


ALTER TABLE public.persona OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 18632)
-- Name: persona_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.persona_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.persona_id_seq OWNER TO postgres;

--
-- TOC entry 3360 (class 0 OID 0)
-- Dependencies: 214
-- Name: persona_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.persona_id_seq OWNED BY public.persona.id;


--
-- TOC entry 3188 (class 2604 OID 18645)
-- Name: cliente clienteid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente ALTER COLUMN clienteid SET DEFAULT nextval('public.cliente_clienteid_seq'::regclass);


--
-- TOC entry 3189 (class 2604 OID 18669)
-- Name: movimiento id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movimiento ALTER COLUMN id SET DEFAULT nextval('public.movimiento_id_seq'::regclass);


--
-- TOC entry 3187 (class 2604 OID 18694)
-- Name: persona id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona ALTER COLUMN id SET DEFAULT nextval('public.persona_id_seq'::regclass);


--
-- TOC entry 3348 (class 0 OID 18642)
-- Dependencies: 217
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cliente VALUES (2, '1234', true, 2);
INSERT INTO public.cliente VALUES (3, '5678', true, 3);
INSERT INTO public.cliente VALUES (4, '1245', true, 4);


--
-- TOC entry 3349 (class 0 OID 18655)
-- Dependencies: 218
-- Data for Name: cuenta; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cuenta VALUES ('478758', 'Ahorros', 1425.00, true, 2);
INSERT INTO public.cuenta VALUES ('225487', 'Corriente', 700.00, true, 3);
INSERT INTO public.cuenta VALUES ('495878', 'Ahorros', 150.00, true, 4);
INSERT INTO public.cuenta VALUES ('496825', 'Ahorros', 0.00, true, 3);
INSERT INTO public.cuenta VALUES ('585545', 'Corriente', 1000.00, true, 2);


--
-- TOC entry 3351 (class 0 OID 18666)
-- Dependencies: 220
-- Data for Name: movimiento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.movimiento VALUES (1, '2024-09-06 00:00:00', 'RETIRO', 500.00, 2500.00, '478758', NULL);
INSERT INTO public.movimiento VALUES (2, '2024-09-06 00:00:00', 'RETIRO', -1000.00, 1500.00, '478758', NULL);
INSERT INTO public.movimiento VALUES (3, '2024-09-06 00:00:00', 'RETIRO', -200.00, 1300.00, '478758', NULL);
INSERT INTO public.movimiento VALUES (4, '2024-09-06 08:26:40.762536', 'RETIRO', -200.00, 1100.00, '478758', NULL);
INSERT INTO public.movimiento VALUES (5, '2024-09-06 08:27:13.346375', 'RETIRO', -1100.00, 0.00, '478758', NULL);
INSERT INTO public.movimiento VALUES (6, '2024-09-06 08:30:01.959901', 'RETIRO', 1200.00, 1200.00, '478758', NULL);
INSERT INTO public.movimiento VALUES (7, '2024-09-06 08:31:20.023966', 'RETIRO', 1200.00, 2400.00, '478758', NULL);
INSERT INTO public.movimiento VALUES (8, '2024-09-06 08:33:42.336569', 'RETIRO', 1200.00, 3600.00, '478758', NULL);
INSERT INTO public.movimiento VALUES (9, '2024-09-06 08:34:53.735061', 'RETIRO', -2000.00, 1600.00, '478758', NULL);
INSERT INTO public.movimiento VALUES (10, '2024-09-06 08:39:54.895721', 'RETIRO', -500.00, 1100.00, '478758', 1600.00);
INSERT INTO public.movimiento VALUES (11, '2024-09-06 08:41:20.833438', 'RETIRO', -500.00, 600.00, '478758', 1100.00);
INSERT INTO public.movimiento VALUES (12, '2024-09-06 08:44:09.071114', 'RETIRO', 1400.00, 2000.00, '478758', 600.00);
INSERT INTO public.movimiento VALUES (13, '2024-09-06 08:45:05.049309', 'RETIRO', 1400.00, 3400.00, '478758', 2000.00);
INSERT INTO public.movimiento VALUES (14, '2024-09-06 08:45:21.903448', 'RETIRO', -1400.00, 2000.00, '478758', 3400.00);
INSERT INTO public.movimiento VALUES (15, '2024-09-06 08:54:16.392517', 'DEPOSITO', 1400.00, 3400.00, '478758', 2000.00);
INSERT INTO public.movimiento VALUES (16, '2024-09-06 08:54:30.738397', 'DEPOSITO', -1400.00, 2000.00, '478758', 3400.00);
INSERT INTO public.movimiento VALUES (17, '2024-09-06 08:54:54.854762', 'DEPOSITO', -140.00, 1860.00, '478758', 2000.00);
INSERT INTO public.movimiento VALUES (18, '2024-09-06 08:55:42.88041', 'RETIRO', -140.00, 1720.00, '478758', 1860.00);
INSERT INTO public.movimiento VALUES (19, '2024-09-06 08:55:47.7066', 'DEPOSITO', 140.00, 1860.00, '478758', 1720.00);
INSERT INTO public.movimiento VALUES (20, '2024-09-06 08:56:33.113488', 'DEPOSITO', 140.00, 2000.00, '478758', 1860.00);
INSERT INTO public.movimiento VALUES (21, '2024-09-06 08:57:07.822144', 'RETIRO', -575.00, 1425.00, '478758', 2000.00);
INSERT INTO public.movimiento VALUES (22, '2024-09-06 08:57:35.049334', 'DEPOSITO', 100.00, 200.00, '225487', 100.00);
INSERT INTO public.movimiento VALUES (23, '2024-09-06 08:57:54.427292', 'DEPOSITO', 500.00, 700.00, '225487', 200.00);
INSERT INTO public.movimiento VALUES (24, '2024-09-06 08:58:19.267353', 'DEPOSITO', 150.00, 150.00, '495878', 0.00);
INSERT INTO public.movimiento VALUES (25, '2024-09-06 08:59:05.22531', 'RETIRO', -540.00, 0.00, '496825', 540.00);
INSERT INTO public.movimiento VALUES (26, '2024-09-06 11:50:35.048853', 'RETIRO', -540.00, 460.00, '585545', 1000.00);
INSERT INTO public.movimiento VALUES (27, '2024-09-06 11:50:52.56869', 'DEPOSITO', 540.00, 1000.00, '585545', 460.00);


--
-- TOC entry 3346 (class 0 OID 18633)
-- Dependencies: 215
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.persona VALUES (2, 'Jose Lema', 'Masculino', 30, '1720161312', 'Otavalo sn y principal', '098254785');
INSERT INTO public.persona VALUES (3, 'Marianela Montalvo', 'Femenino', 25, '1716239825', 'Amazonas y NNUU', '097548965');
INSERT INTO public.persona VALUES (4, 'Juan Osorio', 'Masculino', 35, '1706057450', '13 junio y Equinoccial', '098874587');


--
-- TOC entry 3361 (class 0 OID 0)
-- Dependencies: 216
-- Name: cliente_clienteid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_clienteid_seq', 4, true);


--
-- TOC entry 3362 (class 0 OID 0)
-- Dependencies: 219
-- Name: movimiento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.movimiento_id_seq', 27, true);


--
-- TOC entry 3363 (class 0 OID 0)
-- Dependencies: 214
-- Name: persona_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.persona_id_seq', 4, true);


--
-- TOC entry 3195 (class 2606 OID 18647)
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (clienteid);


--
-- TOC entry 3197 (class 2606 OID 18659)
-- Name: cuenta cuenta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT cuenta_pkey PRIMARY KEY (numero_cuenta);


--
-- TOC entry 3199 (class 2606 OID 18671)
-- Name: movimiento movimiento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movimiento
    ADD CONSTRAINT movimiento_pkey PRIMARY KEY (id);


--
-- TOC entry 3191 (class 2606 OID 18717)
-- Name: persona persona_identificacion_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_identificacion_key UNIQUE (identificacion);


--
-- TOC entry 3193 (class 2606 OID 18696)
-- Name: persona persona_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (id);


--
-- TOC entry 3200 (class 2606 OID 18758)
-- Name: cliente cliente_id_persona_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_id_persona_id FOREIGN KEY (id) REFERENCES public.persona(id);


--
-- TOC entry 3201 (class 2606 OID 18768)
-- Name: cuenta cuenta_clienteid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT cuenta_clienteid_fkey FOREIGN KEY (id_cliente) REFERENCES public.cliente(clienteid);


--
-- TOC entry 3202 (class 2606 OID 18672)
-- Name: movimiento movimiento_numero_cuenta_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movimiento
    ADD CONSTRAINT movimiento_numero_cuenta_fkey FOREIGN KEY (numero_cuenta) REFERENCES public.cuenta(numero_cuenta);


-- Completed on 2024-09-07 00:33:50

--
-- PostgreSQL database dump complete
--


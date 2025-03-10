--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.2

-- Started on 2025-03-10 19:13:18

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
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
-- TOC entry 218 (class 1259 OID 16465)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id bigint NOT NULL,
    username character varying(50) NOT NULL,
    user_password character varying(100) NOT NULL,
    user_salt character varying(100) NOT NULL,
    user_email character varying(50) NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16464)
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_user_id_seq OWNER TO postgres;

--
-- TOC entry 4897 (class 0 OID 0)
-- Dependencies: 217
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;


--
-- TOC entry 4742 (class 2604 OID 16468)
-- Name: users user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN user_id SET DEFAULT nextval('public.users_user_id_seq'::regclass);


--
-- TOC entry 4891 (class 0 OID 16465)
-- Dependencies: 218
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (user_id, username, user_password, user_salt, user_email) FROM stdin;
6	glite	2e738aac894739bc0ed441258298412f71adb00117a3fef49f06657f69960add	c486bc63def65edb224655d028b0b02c976ca7e76e5a07f331c851a942c3a7b3	glite192@gmail.com
7	da	d1abd46f7a16f8ab43294f07b0ec032d7ae2cd19a4c763f953faaf9544d76b6f	30f3e5b0d3449bb4591de33ccf3f6bcc0192beecebc54b2185df6603bbdc4496	glite192@gmail.com
8	d2a	b93e4303dd98c32530ffe52ab49e42d3bcd477532c778feb94bebe5b6664e297	78046f97939a70a6fee66de42018b9252475c6fc1ba8232b5c29c975ca75787f	glite192@gmail.com
9		3036b629a9514df648641521a4a9a447a637789f67f993ef86e7f67ce21af7ec	e16bda168c451be44c16daf139e4d613f159bf36721f8318c8eb1645fc3acaf8	
10	49499494	73456f7b9a4570b54b26706aac195ed404a1131baee711deb98d3480c2d5dc58	64372845cf4b87822e313129920eb6c87b8c74d2acc20c05d4a068133a4aad51	wer2000wer23@gmail.com
11	wer2000wer23@gmail.com	eec92dcdae19f2335be78c78efb89617cca14207c090df41f1ca98d1da8c1fce	63ec12a12124c1de610149bbc25a88aca1f54c9cbfc3dc55337b65e6a090bc96	wer2000wer23@gmail.com
12	wer2000we23@gmail.com	75c616e3c12a0ab0b7b612d7eebf6b840fadf3dd699b31542e11ac2ed5fd01a0	db366dd1bd3a5b4b5ea857930b81c126cf4f9846f83030a46a0ce351fbdc7eb6	wer2000wer23@gmail.com
13	daniklog	088374aee61a656e72b725da425ae13ea1ba66fa67583bbf0c99a6558dc87262	53c0ec49012f7c440f8e4e58b79341170db53b586c2ab0e48bbe3b0b7f9f8a56	wer2000wer23@gmail.com
14	daniki	e75761f370c7631b3d7e7f851a620a6323eb5133c2ce81c2a9ef2638d7c5fac5	ac9ec0e1de4287621bedd09711eb1cf4516bc7e5a338f1afef12e2054b54e8b7	wer2000wer23@gmail.com
15	wer2000wer23@gmail.com 	1bd7f0c2d554b65ef847136a41133ec0249831d50dc75b68997aefb23f20dc1c	dc6ff74b161b9dbaabd8777ccab3a5310fd99ff034ee29e9a941fc812b79a20d	wer2000wer23@gmail.com
16	danikir	f9a745f8294af4fcc3756c5ac95c358d20566966cd85b3b057e8a94cc5516acf	03c80fc13cdf628ed4bbd09be5e1d75c8739dade0c3c7f18a08d1e7ed9518db9	glite192@gmail.com
\.


--
-- TOC entry 4898 (class 0 OID 0)
-- Dependencies: 217
-- Name: users_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_user_id_seq', 16, true);


--
-- TOC entry 4744 (class 2606 OID 16470)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


-- Completed on 2025-03-10 19:13:18

--
-- PostgreSQL database dump complete
--


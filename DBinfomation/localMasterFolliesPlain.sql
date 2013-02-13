--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.3
-- Dumped by pg_dump version 9.2.3
-- Started on 2013-02-11 11:18:13

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 178 (class 3079 OID 11727)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1986 (class 0 OID 0)
-- Dependencies: 178
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 191 (class 1255 OID 16571)
-- Name: batch_insert(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION batch_insert(judge_id integer) RETURNS void
    LANGUAGE sql
    AS $_$insert into results (judge_id, club_id, question_id, points, notes)
select $1 as judge_id, c.id as club_id,q.id as question_id,0 as points, null as notes
from questions q
cross join club_names c$_$;


ALTER FUNCTION public.batch_insert(judge_id integer) OWNER TO postgres;

--
-- TOC entry 192 (class 1255 OID 16572)
-- Name: batch_insert_all(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION batch_insert_all() RETURNS void
    LANGUAGE sql
    AS $$delete from results;
insert into results (judge_id, club_id, question_id, points, notes)
select j.id as judge_id, c.id as club_id,q.id as question_id,0 as points, null as notes
from questions q
cross join club_names c 
cross join judges j;
delete from rank;
insert into rank(judge_id, club_id, rank)
select  judges.id, club_names.id, rank
	from judges, club_names
	left join rank on rank.club_id = club_names.id$$;


ALTER FUNCTION public.batch_insert_all() OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 168 (class 1259 OID 16573)
-- Name: club_names; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE club_names (
    id integer NOT NULL,
    club_name text NOT NULL,
    girl boolean DEFAULT true
);


ALTER TABLE public.club_names OWNER TO postgres;

--
-- TOC entry 169 (class 1259 OID 16580)
-- Name: clubnames_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "clubnames_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."clubnames_ID_seq" OWNER TO postgres;

--
-- TOC entry 1987 (class 0 OID 0)
-- Dependencies: 169
-- Name: clubnames_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "clubnames_ID_seq" OWNED BY club_names.id;


--
-- TOC entry 170 (class 1259 OID 16582)
-- Name: judges; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE judges (
    id integer NOT NULL,
    first_name text NOT NULL,
    last_name text NOT NULL,
    user_name text NOT NULL,
    password text NOT NULL,
    is_super boolean
);


ALTER TABLE public.judges OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 16588)
-- Name: judges_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "judges_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."judges_ID_seq" OWNER TO postgres;

--
-- TOC entry 1988 (class 0 OID 0)
-- Dependencies: 171
-- Name: judges_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "judges_ID_seq" OWNED BY judges.id;


--
-- TOC entry 172 (class 1259 OID 16590)
-- Name: questions; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE questions (
    id integer NOT NULL,
    question text NOT NULL,
    "desc" text
);


ALTER TABLE public.questions OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16596)
-- Name: questions_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "questions_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."questions_ID_seq" OWNER TO postgres;

--
-- TOC entry 1989 (class 0 OID 0)
-- Dependencies: 173
-- Name: questions_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "questions_ID_seq" OWNED BY questions.id;


--
-- TOC entry 174 (class 1259 OID 16598)
-- Name: rank; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE rank (
    judge_id integer NOT NULL,
    club_id integer NOT NULL,
    rank integer,
    id integer NOT NULL
);


ALTER TABLE public.rank OWNER TO postgres;

--
-- TOC entry 1990 (class 0 OID 0)
-- Dependencies: 174
-- Name: COLUMN rank.club_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN rank.club_id IS '
';


--
-- TOC entry 175 (class 1259 OID 16601)
-- Name: rank_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE rank_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rank_id_seq OWNER TO postgres;

--
-- TOC entry 1991 (class 0 OID 0)
-- Dependencies: 175
-- Name: rank_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE rank_id_seq OWNED BY rank.id;


--
-- TOC entry 176 (class 1259 OID 16603)
-- Name: results; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE results (
    id integer NOT NULL,
    judge_id integer NOT NULL,
    club_id integer NOT NULL,
    question_id integer NOT NULL,
    points integer,
    notes text
);


ALTER TABLE public.results OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 16609)
-- Name: results_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "results_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."results_ID_seq" OWNER TO postgres;

--
-- TOC entry 1992 (class 0 OID 0)
-- Dependencies: 177
-- Name: results_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "results_ID_seq" OWNED BY results.id;


--
-- TOC entry 1947 (class 2604 OID 16611)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY club_names ALTER COLUMN id SET DEFAULT nextval('"clubnames_ID_seq"'::regclass);


--
-- TOC entry 1948 (class 2604 OID 16612)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY judges ALTER COLUMN id SET DEFAULT nextval('"judges_ID_seq"'::regclass);


--
-- TOC entry 1949 (class 2604 OID 16613)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY questions ALTER COLUMN id SET DEFAULT nextval('"questions_ID_seq"'::regclass);


--
-- TOC entry 1950 (class 2604 OID 16614)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rank ALTER COLUMN id SET DEFAULT nextval('rank_id_seq'::regclass);


--
-- TOC entry 1951 (class 2604 OID 16615)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY results ALTER COLUMN id SET DEFAULT nextval('"results_ID_seq"'::regclass);


--
-- TOC entry 1969 (class 0 OID 16573)
-- Dependencies: 168
-- Data for Name: club_names; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY club_names (id, club_name, girl) FROM stdin;
5	Alpha Chi Delta	f
6	Koinonia	f
7	Kyodai	f
8	Sub T-16	f
1	Christliche Damen	t
2	Kappa Phi Kappa	t
3	Lambda Omega Alpha	t
4	Zeta Gamma	t
\.


--
-- TOC entry 1993 (class 0 OID 0)
-- Dependencies: 169
-- Name: clubnames_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"clubnames_ID_seq"', 54, true);


--
-- TOC entry 1971 (class 0 OID 16582)
-- Dependencies: 170
-- Data for Name: judges; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY judges (id, first_name, last_name, user_name, password, is_super) FROM stdin;
4	Second	Last	SL	test	\N
1	First	Last	FL	test	\N
67	Hilary	Barnes	HB	test	\N
66	Neil	Saiid	NS	test	t
68	Jodi	P	JP	test	\N
\.


--
-- TOC entry 1994 (class 0 OID 0)
-- Dependencies: 171
-- Name: judges_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"judges_ID_seq"', 72, true);


--
-- TOC entry 1973 (class 0 OID 16590)
-- Dependencies: 172
-- Data for Name: questions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY questions (id, question, "desc") FROM stdin;
1	Costumes / Makeup	<ul>\r\n<li>Concept</li>\r\n<li>Design</li>\r\n<li>Function</li>\r\n</ul>
2	Vocal Expression	<ul>\r\n<li>Diction / clarity</li>\r\n<li>Dynamics</li>\r\n<li>Quality</li>\r\n</ul>
3	Staging / Choreography	<ul>\r\n<li>Precision</li>\r\n<li>Variety</li>\r\n<li>Use of stage</li>\r\n<li>Synchronization</li>\r\n<li>Facial expressions</li>\r\n</ul>
4	Storyline / Dramatic Elements	<ul>\r\n<li>Clear plotline</li>\r\n<li>Characterization</li>\r\n<li>Cohesive storyline</li>\r\n<li>Logical conclusion and climax</li>\r\n</ul>
5	Special Effects	<ul>\r\n<li>Use of props</li>\r\n<li>Backdrop and Video</li>\r\n<li>Quality of recorded audio</li>\r\n<li>Lighting</li>\r\n</ul>
\.


--
-- TOC entry 1995 (class 0 OID 0)
-- Dependencies: 173
-- Name: questions_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"questions_ID_seq"', 5, true);


--
-- TOC entry 1975 (class 0 OID 16598)
-- Dependencies: 174
-- Data for Name: rank; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY rank (judge_id, club_id, rank, id) FROM stdin;
4	2	\N	41
67	2	\N	43
68	2	\N	45
4	5	\N	46
67	5	\N	48
68	5	\N	50
4	8	\N	51
67	8	\N	53
68	8	\N	55
4	6	\N	56
67	6	\N	58
68	6	\N	60
4	4	\N	61
67	4	\N	63
68	4	\N	65
4	1	\N	66
67	1	\N	68
68	1	\N	70
4	3	\N	71
1	3	\N	72
67	3	\N	73
68	3	\N	75
4	7	\N	76
1	7	\N	77
67	7	\N	78
68	7	\N	80
1	1	2	67
1	5	1	47
1	6	2	57
1	8	3	52
1	4	1	62
1	2	3	42
66	5	3	49
66	3	1	74
66	6	1	59
66	1	3	69
66	2	2	44
66	4	0	64
66	8	0	54
66	7	2	79
\.


--
-- TOC entry 1996 (class 0 OID 0)
-- Dependencies: 175
-- Name: rank_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('rank_id_seq', 80, true);


--
-- TOC entry 1977 (class 0 OID 16603)
-- Dependencies: 176
-- Data for Name: results; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY results (id, judge_id, club_id, question_id, points, notes) FROM stdin;
528	1	5	1	1	\N
520	4	5	1	0	\N
521	4	6	1	0	\N
522	4	7	1	0	\N
535	1	4	1	2	\N
523	4	8	1	0	\N
524	4	1	1	0	\N
525	4	2	1	0	\N
526	4	3	1	0	\N
527	4	4	1	0	\N
529	1	6	1	0	\N
530	1	7	1	0	\N
531	1	8	1	0	\N
533	1	2	1	0	\N
534	1	3	1	0	\N
536	67	5	1	0	\N
537	67	6	1	0	\N
538	67	7	1	0	\N
539	67	8	1	0	\N
540	67	1	1	0	\N
541	67	2	1	0	\N
542	67	3	1	0	\N
543	67	4	1	0	\N
545	66	6	1	0	\N
547	66	8	1	0	\N
549	66	2	1	0	\N
551	66	4	1	0	\N
552	68	5	1	0	\N
553	68	6	1	0	\N
554	68	7	1	0	\N
555	68	8	1	0	\N
556	68	1	1	0	\N
557	68	2	1	0	\N
558	68	3	1	0	\N
559	68	4	1	0	\N
560	4	5	2	0	\N
561	4	6	2	0	\N
562	4	7	2	0	\N
563	4	8	2	0	\N
564	4	1	2	0	\N
565	4	2	2	0	\N
566	4	3	2	0	\N
567	4	4	2	0	\N
568	1	5	2	0	\N
569	1	6	2	0	\N
570	1	7	2	0	\N
571	1	8	2	0	\N
573	1	2	2	0	\N
574	1	3	2	0	\N
575	1	4	2	0	\N
576	67	5	2	0	\N
577	67	6	2	0	\N
578	67	7	2	0	\N
579	67	8	2	0	\N
580	67	1	2	0	\N
581	67	2	2	0	\N
582	67	3	2	0	\N
583	67	4	2	0	\N
584	66	5	2	0	\N
585	66	6	2	0	\N
587	66	8	2	0	\N
588	66	1	2	0	\N
589	66	2	2	0	\N
590	66	3	2	0	\N
591	66	4	2	0	\N
592	68	5	2	0	\N
593	68	6	2	0	\N
594	68	7	2	0	\N
595	68	8	2	0	\N
596	68	1	2	0	\N
597	68	2	2	0	\N
598	68	3	2	0	\N
599	68	4	2	0	\N
600	4	5	3	0	\N
601	4	6	3	0	\N
602	4	7	3	0	\N
603	4	8	3	0	\N
604	4	1	3	0	\N
605	4	2	3	0	\N
606	4	3	3	0	\N
607	4	4	3	0	\N
608	1	5	3	0	\N
609	1	6	3	0	\N
610	1	7	3	0	\N
611	1	8	3	0	\N
613	1	2	3	0	\N
614	1	3	3	0	\N
615	1	4	3	0	\N
616	67	5	3	0	\N
617	67	6	3	0	\N
618	67	7	3	0	\N
619	67	8	3	0	\N
620	67	1	3	0	\N
621	67	2	3	0	\N
622	67	3	3	0	\N
623	67	4	3	0	\N
625	66	6	3	0	\N
627	66	8	3	0	\N
628	66	1	3	0	\N
629	66	2	3	0	\N
630	66	3	3	0	\N
631	66	4	3	0	\N
632	68	5	3	0	\N
633	68	6	3	0	\N
634	68	7	3	0	\N
635	68	8	3	0	\N
636	68	1	3	0	\N
637	68	2	3	0	\N
638	68	3	3	0	\N
639	68	4	3	0	\N
640	4	5	4	0	\N
641	4	6	4	0	\N
642	4	7	4	0	\N
643	4	8	4	0	\N
644	4	1	4	0	\N
645	4	2	4	0	\N
646	4	3	4	0	\N
647	4	4	4	0	\N
648	1	5	4	0	\N
649	1	6	4	0	\N
650	1	7	4	0	\N
651	1	8	4	0	\N
653	1	2	4	0	\N
654	1	3	4	0	\N
655	1	4	4	0	\N
656	67	5	4	0	\N
657	67	6	4	0	\N
658	67	7	4	0	\N
659	67	8	4	0	\N
660	67	1	4	0	\N
661	67	2	4	0	\N
662	67	3	4	0	\N
663	67	4	4	0	\N
664	66	5	4	0	\N
665	66	6	4	0	\N
666	66	7	4	0	\N
667	66	8	4	0	\N
668	66	1	4	0	\N
669	66	2	4	0	\N
670	66	3	4	0	\N
671	66	4	4	0	\N
672	68	5	4	0	\N
673	68	6	4	0	\N
674	68	7	4	0	\N
675	68	8	4	0	\N
676	68	1	4	0	\N
548	66	1	1	6	\N
546	66	7	1	9	test stuff
586	66	7	2	8	more test stuff
626	66	7	3	10	i like to test
624	66	5	3	6	synchronized
550	66	3	1	10	blah testings and what not.
544	66	5	1	9	this is great
677	68	2	4	0	\N
678	68	3	4	0	\N
679	68	4	4	0	\N
680	4	5	5	0	\N
681	4	6	5	0	\N
682	4	7	5	0	\N
683	4	8	5	0	\N
684	4	1	5	0	\N
685	4	2	5	0	\N
686	4	3	5	0	\N
687	4	4	5	0	\N
688	1	5	5	0	\N
689	1	6	5	0	\N
690	1	7	5	0	\N
691	1	8	5	0	\N
693	1	2	5	0	\N
694	1	3	5	0	\N
695	1	4	5	0	\N
696	67	5	5	0	\N
697	67	6	5	0	\N
698	67	7	5	0	\N
699	67	8	5	0	\N
700	67	1	5	0	\N
701	67	2	5	0	\N
702	67	3	5	0	\N
703	67	4	5	0	\N
704	66	5	5	0	\N
705	66	6	5	0	\N
706	66	7	5	0	\N
707	66	8	5	0	\N
708	66	1	5	0	\N
709	66	2	5	0	\N
710	66	3	5	0	\N
711	66	4	5	0	\N
712	68	5	5	0	\N
713	68	6	5	0	\N
714	68	7	5	0	\N
715	68	8	5	0	\N
716	68	1	5	0	\N
717	68	2	5	0	\N
718	68	3	5	0	\N
719	68	4	5	0	\N
\.


--
-- TOC entry 1997 (class 0 OID 0)
-- Dependencies: 177
-- Name: results_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"results_ID_seq"', 731, true);


--
-- TOC entry 1953 (class 2606 OID 16617)
-- Name: clubnames_ID_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY club_names
    ADD CONSTRAINT "clubnames_ID_key" PRIMARY KEY (id);


--
-- TOC entry 1961 (class 2606 OID 16619)
-- Name: id_as_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY rank
    ADD CONSTRAINT id_as_pkey PRIMARY KEY (id);


--
-- TOC entry 1963 (class 2606 OID 16621)
-- Name: judge_club_question_unique; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY results
    ADD CONSTRAINT judge_club_question_unique UNIQUE (judge_id, club_id, question_id);


--
-- TOC entry 1955 (class 2606 OID 16623)
-- Name: judges_Username_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY judges
    ADD CONSTRAINT "judges_Username_key" UNIQUE (user_name);


--
-- TOC entry 1957 (class 2606 OID 16625)
-- Name: judges_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY judges
    ADD CONSTRAINT judges_pkey PRIMARY KEY (id);


--
-- TOC entry 1959 (class 2606 OID 16627)
-- Name: questions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY questions
    ADD CONSTRAINT questions_pkey PRIMARY KEY (id);


--
-- TOC entry 1965 (class 2606 OID 16629)
-- Name: serial_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY results
    ADD CONSTRAINT serial_pkey PRIMARY KEY (id);


--
-- TOC entry 1966 (class 2606 OID 16630)
-- Name: club_id_as_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rank
    ADD CONSTRAINT club_id_as_fkey FOREIGN KEY (club_id) REFERENCES club_names(id) MATCH FULL;


--
-- TOC entry 1968 (class 2606 OID 16635)
-- Name: fk_judges_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY results
    ADD CONSTRAINT fk_judges_id FOREIGN KEY (judge_id) REFERENCES judges(id);


--
-- TOC entry 1967 (class 2606 OID 16640)
-- Name: judge_id_as_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rank
    ADD CONSTRAINT judge_id_as_fkey FOREIGN KEY (judge_id) REFERENCES judges(id) MATCH FULL;


--
-- TOC entry 1985 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2013-02-11 11:18:14

--
-- PostgreSQL database dump complete
--


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

--CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1986 (class 0 OID 0)
-- Dependencies: 178
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

--COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--SET search_path = public, pg_catalog;

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


ALTER FUNCTION public.batch_insert(judge_id integer);

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


ALTER FUNCTION public.batch_insert_all();


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



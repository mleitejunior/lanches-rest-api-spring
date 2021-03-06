PGDMP     7                	    x            lanches    13.0    13.0     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16384    lanches    DATABASE     [   CREATE DATABASE lanches WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';
    DROP DATABASE lanches;
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    3            �            1259    17306    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false    3            �            1259    17276    tbl_ingredient    TABLE     �   CREATE TABLE public.tbl_ingredient (
    tbl_ingredient_id integer NOT NULL,
    cost_per_item double precision NOT NULL,
    ingredient_type character varying(255),
    name character varying(255) NOT NULL
);
 "   DROP TABLE public.tbl_ingredient;
       public         heap    postgres    false    3            �            1259    17284 	   tbl_order    TABLE     g   CREATE TABLE public.tbl_order (
    tbl_order_id integer NOT NULL,
    total_price double precision
);
    DROP TABLE public.tbl_order;
       public         heap    postgres    false    3            �            1259    17289    tbl_order_item    TABLE     �   CREATE TABLE public.tbl_order_item (
    tbl_order_item_id integer NOT NULL,
    ingredient_price double precision,
    tbl_ingredient_id integer NOT NULL,
    tbl_order_id integer NOT NULL
);
 "   DROP TABLE public.tbl_order_item;
       public         heap    postgres    false    3            �            1259    17294    tbl_sandwich    TABLE     u   CREATE TABLE public.tbl_sandwich (
    tbl_sandwich_id integer NOT NULL,
    name character varying(255) NOT NULL
);
     DROP TABLE public.tbl_sandwich;
       public         heap    postgres    false    3            �            1259    17299    tbl_sandwich_has_ingredient    TABLE     �   CREATE TABLE public.tbl_sandwich_has_ingredient (
    tbl_sandwich_id integer NOT NULL,
    tbl_ingredient_id integer NOT NULL
);
 /   DROP TABLE public.tbl_sandwich_has_ingredient;
       public         heap    postgres    false    3            �          0    17276    tbl_ingredient 
   TABLE DATA           a   COPY public.tbl_ingredient (tbl_ingredient_id, cost_per_item, ingredient_type, name) FROM stdin;
    public          postgres    false    200            �          0    17284 	   tbl_order 
   TABLE DATA           >   COPY public.tbl_order (tbl_order_id, total_price) FROM stdin;
    public          postgres    false    201            �          0    17289    tbl_order_item 
   TABLE DATA           n   COPY public.tbl_order_item (tbl_order_item_id, ingredient_price, tbl_ingredient_id, tbl_order_id) FROM stdin;
    public          postgres    false    202            �          0    17294    tbl_sandwich 
   TABLE DATA           =   COPY public.tbl_sandwich (tbl_sandwich_id, name) FROM stdin;
    public          postgres    false    203            �          0    17299    tbl_sandwich_has_ingredient 
   TABLE DATA           Y   COPY public.tbl_sandwich_has_ingredient (tbl_sandwich_id, tbl_ingredient_id) FROM stdin;
    public          postgres    false    204            �           0    0    hibernate_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hibernate_sequence', 6, true);
          public          postgres    false    205            4           2606    17283 "   tbl_ingredient tbl_ingredient_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.tbl_ingredient
    ADD CONSTRAINT tbl_ingredient_pkey PRIMARY KEY (tbl_ingredient_id);
 L   ALTER TABLE ONLY public.tbl_ingredient DROP CONSTRAINT tbl_ingredient_pkey;
       public            postgres    false    200            :           2606    17293 "   tbl_order_item tbl_order_item_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.tbl_order_item
    ADD CONSTRAINT tbl_order_item_pkey PRIMARY KEY (tbl_order_item_id);
 L   ALTER TABLE ONLY public.tbl_order_item DROP CONSTRAINT tbl_order_item_pkey;
       public            postgres    false    202            8           2606    17288    tbl_order tbl_order_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.tbl_order
    ADD CONSTRAINT tbl_order_pkey PRIMARY KEY (tbl_order_id);
 B   ALTER TABLE ONLY public.tbl_order DROP CONSTRAINT tbl_order_pkey;
       public            postgres    false    201            <           2606    17298    tbl_sandwich tbl_sandwich_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.tbl_sandwich
    ADD CONSTRAINT tbl_sandwich_pkey PRIMARY KEY (tbl_sandwich_id);
 H   ALTER TABLE ONLY public.tbl_sandwich DROP CONSTRAINT tbl_sandwich_pkey;
       public            postgres    false    203            >           2606    17305 )   tbl_sandwich uk_9nqw4si61esw8bixo7s8d5jwe 
   CONSTRAINT     d   ALTER TABLE ONLY public.tbl_sandwich
    ADD CONSTRAINT uk_9nqw4si61esw8bixo7s8d5jwe UNIQUE (name);
 S   ALTER TABLE ONLY public.tbl_sandwich DROP CONSTRAINT uk_9nqw4si61esw8bixo7s8d5jwe;
       public            postgres    false    203            6           2606    17303 +   tbl_ingredient uk_llpxsgbj7g8llrb982caed0js 
   CONSTRAINT     f   ALTER TABLE ONLY public.tbl_ingredient
    ADD CONSTRAINT uk_llpxsgbj7g8llrb982caed0js UNIQUE (name);
 U   ALTER TABLE ONLY public.tbl_ingredient DROP CONSTRAINT uk_llpxsgbj7g8llrb982caed0js;
       public            postgres    false    200            @           2606    17313 *   tbl_order_item fkbwvxweep37lo58y373l5sea5w    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_order_item
    ADD CONSTRAINT fkbwvxweep37lo58y373l5sea5w FOREIGN KEY (tbl_order_id) REFERENCES public.tbl_order(tbl_order_id);
 T   ALTER TABLE ONLY public.tbl_order_item DROP CONSTRAINT fkbwvxweep37lo58y373l5sea5w;
       public          postgres    false    2872    202    201            ?           2606    17308 *   tbl_order_item fkibkbstw5qtgvlubrk2w8svy8u    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_order_item
    ADD CONSTRAINT fkibkbstw5qtgvlubrk2w8svy8u FOREIGN KEY (tbl_ingredient_id) REFERENCES public.tbl_ingredient(tbl_ingredient_id);
 T   ALTER TABLE ONLY public.tbl_order_item DROP CONSTRAINT fkibkbstw5qtgvlubrk2w8svy8u;
       public          postgres    false    202    200    2868            B           2606    17323 7   tbl_sandwich_has_ingredient fkl5e7fcl6eosf3w943mvv1dupk    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_sandwich_has_ingredient
    ADD CONSTRAINT fkl5e7fcl6eosf3w943mvv1dupk FOREIGN KEY (tbl_sandwich_id) REFERENCES public.tbl_sandwich(tbl_sandwich_id);
 a   ALTER TABLE ONLY public.tbl_sandwich_has_ingredient DROP CONSTRAINT fkl5e7fcl6eosf3w943mvv1dupk;
       public          postgres    false    2876    204    203            A           2606    17318 7   tbl_sandwich_has_ingredient fkrihtxbdfc0ftkhgheng89v5t8    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_sandwich_has_ingredient
    ADD CONSTRAINT fkrihtxbdfc0ftkhgheng89v5t8 FOREIGN KEY (tbl_ingredient_id) REFERENCES public.tbl_ingredient(tbl_ingredient_id);
 a   ALTER TABLE ONLY public.tbl_sandwich_has_ingredient DROP CONSTRAINT fkrihtxbdfc0ftkhgheng89v5t8;
       public          postgres    false    200    2868    204            �   |   x�3�4�3�t�qstv�L�IKLN�2�4�trt���LJL���2�4��p�u
ru��H�M:��(�4����݂�?4$�?�3�,�˔�Pϔ30���˟��453+��hTIAfrNj1W� �� �      �      x������ � �      �      x������ � �      �   -   x�3��MJL���2�J��KS�������t.� Q���� ja�      �   .   x���	 0��w<L!��M�����C겺+Sө`�
>��{$=��Y          �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16384    lanches    DATABASE     [   CREATE DATABASE lanches WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';
    DROP DATABASE lanches;
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    3            �            1259    17306    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false    3            �            1259    17276    tbl_ingredient    TABLE     �   CREATE TABLE public.tbl_ingredient (
    tbl_ingredient_id integer NOT NULL,
    cost_per_item double precision NOT NULL,
    ingredient_type character varying(255),
    name character varying(255) NOT NULL
);
 "   DROP TABLE public.tbl_ingredient;
       public         heap    postgres    false    3            �            1259    17284 	   tbl_order    TABLE     g   CREATE TABLE public.tbl_order (
    tbl_order_id integer NOT NULL,
    total_price double precision
);
    DROP TABLE public.tbl_order;
       public         heap    postgres    false    3            �            1259    17289    tbl_order_item    TABLE     �   CREATE TABLE public.tbl_order_item (
    tbl_order_item_id integer NOT NULL,
    ingredient_price double precision,
    tbl_ingredient_id integer NOT NULL,
    tbl_order_id integer NOT NULL
);
 "   DROP TABLE public.tbl_order_item;
       public         heap    postgres    false    3            �            1259    17294    tbl_sandwich    TABLE     u   CREATE TABLE public.tbl_sandwich (
    tbl_sandwich_id integer NOT NULL,
    name character varying(255) NOT NULL
);
     DROP TABLE public.tbl_sandwich;
       public         heap    postgres    false    3            �            1259    17299    tbl_sandwich_has_ingredient    TABLE     �   CREATE TABLE public.tbl_sandwich_has_ingredient (
    tbl_sandwich_id integer NOT NULL,
    tbl_ingredient_id integer NOT NULL
);
 /   DROP TABLE public.tbl_sandwich_has_ingredient;
       public         heap    postgres    false    3            �          0    17276    tbl_ingredient 
   TABLE DATA           a   COPY public.tbl_ingredient (tbl_ingredient_id, cost_per_item, ingredient_type, name) FROM stdin;
    public          postgres    false    200          �          0    17284 	   tbl_order 
   TABLE DATA           >   COPY public.tbl_order (tbl_order_id, total_price) FROM stdin;
    public          postgres    false    201   �        �          0    17289    tbl_order_item 
   TABLE DATA           n   COPY public.tbl_order_item (tbl_order_item_id, ingredient_price, tbl_ingredient_id, tbl_order_id) FROM stdin;
    public          postgres    false    202           �          0    17294    tbl_sandwich 
   TABLE DATA           =   COPY public.tbl_sandwich (tbl_sandwich_id, name) FROM stdin;
    public          postgres    false    203           �          0    17299    tbl_sandwich_has_ingredient 
   TABLE DATA           Y   COPY public.tbl_sandwich_has_ingredient (tbl_sandwich_id, tbl_ingredient_id) FROM stdin;
    public          postgres    false    204   7        �           0    0    hibernate_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hibernate_sequence', 6, true);
          public          postgres    false    205            4           2606    17283 "   tbl_ingredient tbl_ingredient_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.tbl_ingredient
    ADD CONSTRAINT tbl_ingredient_pkey PRIMARY KEY (tbl_ingredient_id);
 L   ALTER TABLE ONLY public.tbl_ingredient DROP CONSTRAINT tbl_ingredient_pkey;
       public            postgres    false    200            :           2606    17293 "   tbl_order_item tbl_order_item_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.tbl_order_item
    ADD CONSTRAINT tbl_order_item_pkey PRIMARY KEY (tbl_order_item_id);
 L   ALTER TABLE ONLY public.tbl_order_item DROP CONSTRAINT tbl_order_item_pkey;
       public            postgres    false    202            8           2606    17288    tbl_order tbl_order_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.tbl_order
    ADD CONSTRAINT tbl_order_pkey PRIMARY KEY (tbl_order_id);
 B   ALTER TABLE ONLY public.tbl_order DROP CONSTRAINT tbl_order_pkey;
       public            postgres    false    201            <           2606    17298    tbl_sandwich tbl_sandwich_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.tbl_sandwich
    ADD CONSTRAINT tbl_sandwich_pkey PRIMARY KEY (tbl_sandwich_id);
 H   ALTER TABLE ONLY public.tbl_sandwich DROP CONSTRAINT tbl_sandwich_pkey;
       public            postgres    false    203            >           2606    17305 )   tbl_sandwich uk_9nqw4si61esw8bixo7s8d5jwe 
   CONSTRAINT     d   ALTER TABLE ONLY public.tbl_sandwich
    ADD CONSTRAINT uk_9nqw4si61esw8bixo7s8d5jwe UNIQUE (name);
 S   ALTER TABLE ONLY public.tbl_sandwich DROP CONSTRAINT uk_9nqw4si61esw8bixo7s8d5jwe;
       public            postgres    false    203            6           2606    17303 +   tbl_ingredient uk_llpxsgbj7g8llrb982caed0js 
   CONSTRAINT     f   ALTER TABLE ONLY public.tbl_ingredient
    ADD CONSTRAINT uk_llpxsgbj7g8llrb982caed0js UNIQUE (name);
 U   ALTER TABLE ONLY public.tbl_ingredient DROP CONSTRAINT uk_llpxsgbj7g8llrb982caed0js;
       public            postgres    false    200            @           2606    17313 *   tbl_order_item fkbwvxweep37lo58y373l5sea5w    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_order_item
    ADD CONSTRAINT fkbwvxweep37lo58y373l5sea5w FOREIGN KEY (tbl_order_id) REFERENCES public.tbl_order(tbl_order_id);
 T   ALTER TABLE ONLY public.tbl_order_item DROP CONSTRAINT fkbwvxweep37lo58y373l5sea5w;
       public          postgres    false    2872    202    201            ?           2606    17308 *   tbl_order_item fkibkbstw5qtgvlubrk2w8svy8u    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_order_item
    ADD CONSTRAINT fkibkbstw5qtgvlubrk2w8svy8u FOREIGN KEY (tbl_ingredient_id) REFERENCES public.tbl_ingredient(tbl_ingredient_id);
 T   ALTER TABLE ONLY public.tbl_order_item DROP CONSTRAINT fkibkbstw5qtgvlubrk2w8svy8u;
       public          postgres    false    202    200    2868            B           2606    17323 7   tbl_sandwich_has_ingredient fkl5e7fcl6eosf3w943mvv1dupk    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_sandwich_has_ingredient
    ADD CONSTRAINT fkl5e7fcl6eosf3w943mvv1dupk FOREIGN KEY (tbl_sandwich_id) REFERENCES public.tbl_sandwich(tbl_sandwich_id);
 a   ALTER TABLE ONLY public.tbl_sandwich_has_ingredient DROP CONSTRAINT fkl5e7fcl6eosf3w943mvv1dupk;
       public          postgres    false    2876    204    203            A           2606    17318 7   tbl_sandwich_has_ingredient fkrihtxbdfc0ftkhgheng89v5t8    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_sandwich_has_ingredient
    ADD CONSTRAINT fkrihtxbdfc0ftkhgheng89v5t8 FOREIGN KEY (tbl_ingredient_id) REFERENCES public.tbl_ingredient(tbl_ingredient_id);
 a   ALTER TABLE ONLY public.tbl_sandwich_has_ingredient DROP CONSTRAINT fkrihtxbdfc0ftkhgheng89v5t8;
       public          postgres    false    200    2868    204           
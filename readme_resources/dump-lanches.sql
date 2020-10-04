PGDMP         '            	    x            lanches    13.0    13.0     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
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
                postgres    false            �           0    0 
   SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    3            �            1259    16397    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false    3            �            1259    17143 
   ingredient    TABLE     �   CREATE TABLE public.ingredient (
    ingredient_id integer NOT NULL,
    cost_per_item double precision NOT NULL,
    ingredient_type character varying(255),
    name character varying(255) NOT NULL
);
    DROP TABLE public.ingredient;
       public         heap    postgres    false    3            �            1259    17193    sandwich    TABLE     e   CREATE TABLE public.order (
    sandwich_id integer NOT NULL,
    total_price double precision
);
    DROP TABLE public.order;
       public         heap    postgres    false    3            �            1259    17198 
   sandwich_item    TABLE     �   CREATE TABLE public.sandwich_item (
    sandwich_item_id integer NOT NULL,
    ingredient_price double precision,
    ingredient_id integer NOT NULL,
    sandwich_id integer NOT NULL
);
 !   DROP TABLE public.sandwich_item;
       public         heap    postgres    false    3            �            1259    17213    sandwich_recipe    TABLE     {   CREATE TABLE public.sandwich_recipe (
    sandwich_recipe_id integer NOT NULL,
    name character varying(255) NOT NULL
);
 #   DROP TABLE public.sandwich_recipe;
       public         heap    postgres    false    3            �            1259    17218    sandwich_recipe_has_ingredient    TABLE     �   CREATE TABLE public.sandwich_recipe_has_ingredient (
    sandwich_recipe_id integer NOT NULL,
    ingredient_id integer NOT NULL
);
 2   DROP TABLE public.sandwich_recipe_has_ingredient;
       public         heap    postgres    false    3            �          0    17143 
   ingredient 
   TABLE DATA           Y   COPY public.ingredient (ingredient_id, cost_per_item, ingredient_type, name) FROM stdin;
    public          postgres    false    201            �          0    17193    sandwich 
   TABLE DATA           <   COPY public.order (sandwich_id, total_price) FROM stdin;
    public          postgres    false    202            �          0    17198 
   sandwich_item 
   TABLE DATA           g   COPY public.sandwich_item (sandwich_item_id, ingredient_price, ingredient_id, sandwich_id) FROM stdin;
    public          postgres    false    203            �          0    17213    sandwich_recipe 
   TABLE DATA           C   COPY public.sandwich_recipe (sandwich_recipe_id, name) FROM stdin;
    public          postgres    false    204            �          0    17218    sandwich_recipe_has_ingredient 
   TABLE DATA           [   COPY public.sandwich_recipe_has_ingredient (sandwich_recipe_id, ingredient_id) FROM stdin;
    public          postgres    false    205            �           0    0    hibernate_sequence    SEQUENCE SET     B   SELECT pg_catalog.setval('public.hibernate_sequence', 134, true);
          public          postgres    false    200            4           2606    17150    ingredient ingredient_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.ingredient
    ADD CONSTRAINT ingredient_pkey PRIMARY KEY (ingredient_id);
 D   ALTER TABLE ONLY public.ingredient DROP CONSTRAINT ingredient_pkey;
       public            postgres    false    201            :           2606    17202     sandwich_item sandwich_item_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.sandwich_item
    ADD CONSTRAINT sandwich_item_pkey PRIMARY KEY (sandwich_item_id);
 J   ALTER TABLE ONLY public.sandwich_item DROP CONSTRAINT sandwich_item_pkey;
       public            postgres    false    203            8           2606    17197    sandwich sandwich_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.order
    ADD CONSTRAINT sandwich_pkey PRIMARY KEY (sandwich_id);
 @   ALTER TABLE ONLY public.order DROP CONSTRAINT sandwich_pkey;
       public            postgres    false    202            <           2606    17217 $   sandwich_recipe sandwich_recipe_pkey 
   CONSTRAINT     r   ALTER TABLE ONLY public.sandwich_recipe
    ADD CONSTRAINT sandwich_recipe_pkey PRIMARY KEY (sandwich_recipe_id);
 N   ALTER TABLE ONLY public.sandwich_recipe DROP CONSTRAINT sandwich_recipe_pkey;
       public            postgres    false    204            6           2606    17170 '   ingredient uk_bcuaj97y3iu3t2vj26jg6hijj 
   CONSTRAINT     b   ALTER TABLE ONLY public.ingredient
    ADD CONSTRAINT uk_bcuaj97y3iu3t2vj26jg6hijj UNIQUE (name);
 Q   ALTER TABLE ONLY public.ingredient DROP CONSTRAINT uk_bcuaj97y3iu3t2vj26jg6hijj;
       public            postgres    false    201            >           2606    17222 ,   sandwich_recipe uk_iwe8gq4sr6ymtcpw2y5u5ogsa 
   CONSTRAINT     g   ALTER TABLE ONLY public.sandwich_recipe
    ADD CONSTRAINT uk_iwe8gq4sr6ymtcpw2y5u5ogsa UNIQUE (name);
 V   ALTER TABLE ONLY public.sandwich_recipe DROP CONSTRAINT uk_iwe8gq4sr6ymtcpw2y5u5ogsa;
       public            postgres    false    204            ?           2606    17203 )   sandwich_item fkae9h3dth0ibvgh21l38df4bue 
   FK CONSTRAINT     �   ALTER TABLE ONLY public.sandwich_item
    ADD CONSTRAINT fkae9h3dth0ibvgh21l38df4bue FOREIGN KEY (ingredient_id) REFERENCES public.ingredient(ingredient_id);
 S   ALTER TABLE ONLY public.sandwich_item DROP CONSTRAINT fkae9h3dth0ibvgh21l38df4bue;
       public          postgres    false    203    201    2868            A           2606    17223 :   sandwich_recipe_has_ingredient fkbm8tg64x20v4gx1yya7sq2rdt 
   FK CONSTRAINT     �   ALTER TABLE ONLY public.sandwich_recipe_has_ingredient
    ADD CONSTRAINT fkbm8tg64x20v4gx1yya7sq2rdt FOREIGN KEY (ingredient_id) REFERENCES public.ingredient(ingredient_id);
 d   ALTER TABLE ONLY public.sandwich_recipe_has_ingredient DROP CONSTRAINT fkbm8tg64x20v4gx1yya7sq2rdt;
       public          postgres    false    2868    201    205            B           2606    17228 :   sandwich_recipe_has_ingredient fkgdydicppebfb1xrcgpgoljh0x 
   FK CONSTRAINT     �   ALTER TABLE ONLY public.sandwich_recipe_has_ingredient
    ADD CONSTRAINT fkgdydicppebfb1xrcgpgoljh0x FOREIGN KEY (sandwich_recipe_id) REFERENCES public.sandwich_recipe(sandwich_recipe_id);
 d   ALTER TABLE ONLY public.sandwich_recipe_has_ingredient DROP CONSTRAINT fkgdydicppebfb1xrcgpgoljh0x;
       public          postgres    false    205    2876    204            @           2606    17208 )   sandwich_item fkmcovmrxwtes9ukl9pkregvgnx 
   FK CONSTRAINT     �   ALTER TABLE ONLY public.sandwich_item
    ADD CONSTRAINT fkmcovmrxwtes9ukl9pkregvgnx FOREIGN KEY (sandwich_id) REFERENCES public.order(sandwich_id);
 S   ALTER TABLE ONLY public.sandwich_item DROP CONSTRAINT fkmcovmrxwtes9ukl9pkregvgnx;
       public          postgres    false    202    2872    203            �   p   x�3�4�3�t�qstv�L�IKLN�2�4�trt���LJL���2�4��p�u

ru
��H�M:��(�4����݂�?4$�?�3�,�˔�Pϔ30���˟��453+�+F��� �q�      �   
   x������ � �      �   
   x������ � �      �   -   x�3��MJL���2�J��KS�������t.� Q���� ja
�      �   .   x�
��
 @��2�%"n��s\MiB��5�26�
���С�I���Y          �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
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
                postgres    false            �           0    0 
   SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    3            �            1259    16397    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false    3            �            1259    17143 
   ingredient    TABLE     �   CREATE TABLE public.ingredient (
    ingredient_id integer NOT NULL,
    cost_per_item double precision NOT NULL,
    ingredient_type character varying(255),
    name character varying(255) NOT NULL
);
    DROP TABLE public.ingredient;
       public         heap    postgres    false    3            �            1259    17193    sandwich    TABLE     e   CREATE TABLE public.order (
    sandwich_id integer NOT NULL,
    total_price double precision
);
    DROP TABLE public.order;
       public         heap    postgres    false    3            �            1259    17198 
   sandwich_item    TABLE     �   CREATE TABLE public.sandwich_item (
    sandwich_item_id integer NOT NULL,
    ingredient_price double precision,
    ingredient_id integer NOT NULL,
    sandwich_id integer NOT NULL
);
 !   DROP TABLE public.sandwich_item;
       public         heap    postgres    false    3            �            1259    17213    sandwich_recipe    TABLE     {   CREATE TABLE public.sandwich_recipe (
    sandwich_recipe_id integer NOT NULL,
    name character varying(255) NOT NULL
);
 #   DROP TABLE public.sandwich_recipe;
       public         heap    postgres    false    3            �            1259    17218    sandwich_recipe_has_ingredient    TABLE     �   CREATE TABLE public.sandwich_recipe_has_ingredient (
    sandwich_recipe_id integer NOT NULL,
    ingredient_id integer NOT NULL
);
 2   DROP TABLE public.sandwich_recipe_has_ingredient;
       public         heap    postgres    false    3            �          0    17143 
   ingredient 
   TABLE DATA           Y   COPY public.ingredient (ingredient_id, cost_per_item, ingredient_type, name) FROM stdin;
    public          postgres    false    201   �        �          0    17193    sandwich 
   TABLE DATA           <   COPY public.order (sandwich_id, total_price) FROM stdin;
    public          postgres    false    202   z        �          0    17198 
   sandwich_item 
   TABLE DATA           g   COPY public.sandwich_item (sandwich_item_id, ingredient_price, ingredient_id, sandwich_id) FROM stdin;
    public          postgres    false    203           �          0    17213    sandwich_recipe 
   TABLE DATA           C   COPY public.sandwich_recipe (sandwich_recipe_id, name) FROM stdin;
    public          postgres    false    204           �          0    17218    sandwich_recipe_has_ingredient 
   TABLE DATA           [   COPY public.sandwich_recipe_has_ingredient (sandwich_recipe_id, ingredient_id) FROM stdin;
    public          postgres    false    205   7        �           0    0    hibernate_sequence    SEQUENCE SET     B   SELECT pg_catalog.setval('public.hibernate_sequence', 134, true);
          public          postgres    false    200            4           2606    17150    ingredient ingredient_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.ingredient
    ADD CONSTRAINT ingredient_pkey PRIMARY KEY (ingredient_id);
 D   ALTER TABLE ONLY public.ingredient DROP CONSTRAINT ingredient_pkey;
       public            postgres    false    201            :           2606    17202     sandwich_item sandwich_item_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.sandwich_item
    ADD CONSTRAINT sandwich_item_pkey PRIMARY KEY (sandwich_item_id);
 J   ALTER TABLE ONLY public.sandwich_item DROP CONSTRAINT sandwich_item_pkey;
       public            postgres    false    203            8           2606    17197    sandwich sandwich_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.order
    ADD CONSTRAINT sandwich_pkey PRIMARY KEY (sandwich_id);
 @   ALTER TABLE ONLY public.order DROP CONSTRAINT sandwich_pkey;
       public            postgres    false    202            <           2606    17217 $   sandwich_recipe sandwich_recipe_pkey 
   CONSTRAINT     r   ALTER TABLE ONLY public.sandwich_recipe
    ADD CONSTRAINT sandwich_recipe_pkey PRIMARY KEY (sandwich_recipe_id);
 N   ALTER TABLE ONLY public.sandwich_recipe DROP CONSTRAINT sandwich_recipe_pkey;
       public            postgres    false    204            6           2606    17170 '   ingredient uk_bcuaj97y3iu3t2vj26jg6hijj 
   CONSTRAINT     b   ALTER TABLE ONLY public.ingredient
    ADD CONSTRAINT uk_bcuaj97y3iu3t2vj26jg6hijj UNIQUE (name);
 Q   ALTER TABLE ONLY public.ingredient DROP CONSTRAINT uk_bcuaj97y3iu3t2vj26jg6hijj;
       public            postgres    false    201            >           2606    17222 ,   sandwich_recipe uk_iwe8gq4sr6ymtcpw2y5u5ogsa 
   CONSTRAINT     g   ALTER TABLE ONLY public.sandwich_recipe
    ADD CONSTRAINT uk_iwe8gq4sr6ymtcpw2y5u5ogsa UNIQUE (name);
 V   ALTER TABLE ONLY public.sandwich_recipe DROP CONSTRAINT uk_iwe8gq4sr6ymtcpw2y5u5ogsa;
       public            postgres    false    204            ?           2606    17203 )   sandwich_item fkae9h3dth0ibvgh21l38df4bue 
   FK CONSTRAINT     �   ALTER TABLE ONLY public.sandwich_item
    ADD CONSTRAINT fkae9h3dth0ibvgh21l38df4bue FOREIGN KEY (ingredient_id) REFERENCES public.ingredient(ingredient_id);
 S   ALTER TABLE ONLY public.sandwich_item DROP CONSTRAINT fkae9h3dth0ibvgh21l38df4bue;
       public          postgres    false    203    201    2868            A           2606    17223 :   sandwich_recipe_has_ingredient fkbm8tg64x20v4gx1yya7sq2rdt 
   FK CONSTRAINT     �   ALTER TABLE ONLY public.sandwich_recipe_has_ingredient
    ADD CONSTRAINT fkbm8tg64x20v4gx1yya7sq2rdt FOREIGN KEY (ingredient_id) REFERENCES public.ingredient(ingredient_id);
 d   ALTER TABLE ONLY public.sandwich_recipe_has_ingredient DROP CONSTRAINT fkbm8tg64x20v4gx1yya7sq2rdt;
       public          postgres    false    2868    201    205            B           2606    17228 :   sandwich_recipe_has_ingredient fkgdydicppebfb1xrcgpgoljh0x 
   FK CONSTRAINT     �   ALTER TABLE ONLY public.sandwich_recipe_has_ingredient
    ADD CONSTRAINT fkgdydicppebfb1xrcgpgoljh0x FOREIGN KEY (sandwich_recipe_id) REFERENCES public.sandwich_recipe(sandwich_recipe_id);
 d   ALTER TABLE ONLY public.sandwich_recipe_has_ingredient DROP CONSTRAINT fkgdydicppebfb1xrcgpgoljh0x;
       public          postgres    false    205    2876    204            @           2606    17208 )   sandwich_item fkmcovmrxwtes9ukl9pkregvgnx 
   FK CONSTRAINT     �   ALTER TABLE ONLY public.sandwich_item
    ADD CONSTRAINT fkmcovmrxwtes9ukl9pkregvgnx FOREIGN KEY (sandwich_id) REFERENCES public.order(sandwich_id);
 S   ALTER TABLE ONLY public.sandwich_item DROP CONSTRAINT fkmcovmrxwtes9ukl9pkregvgnx;
       public          postgres    false    202    2872    203           
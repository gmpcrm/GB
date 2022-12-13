# coding: utf-8
from sqlalchemy import Column, Integer, Table, Text
from sqlalchemy.sql.sqltypes import NullType
from sqlalchemy.ext.declarative import declarative_base

Base = declarative_base()
metadata = Base.metadata

users = Table(
    'users', metadata,
    Column('Id', Integer, primary_key=True),
    Column('FirstName', Text, nullable=False),
    Column('LastName', Text, nullable=False),
    Column('Surname', Text),
    Column('Birthday', Integer),
    Column('Phone', Text),
    Column('Status', Text, nullable=False)
)

t_sqlite_sequence = Table(
    'sqlite_sequence', metadata,
    Column('name', NullType),
    Column('seq', NullType)
)

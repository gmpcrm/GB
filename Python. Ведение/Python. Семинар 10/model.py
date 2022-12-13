import os
from sqlalchemy import create_engine, select
from sqlalchemy.sql import or_
from models import users

basedir = os.path.abspath(os.path.dirname(__file__))
engine = create_engine('sqlite:///' + os.path.join(basedir, 'database.db'), echo=True, future=True)
token = os.path.join(basedir, 'token.txt')

def get_TOKEN():
    with open(token) as f:
        return f.read().strip()

def get_all_columns():
    return users.c.keys()

def get_columns():
    return ['Id', 'FirstName', 'LastName', 'SurName']

def query_rows(stmt):
    with engine.connect() as conn:
        rows = []
        for row in conn.execute(stmt):
            rows.append(row)
        return rows

def get_students():
    return query_rows(select(users.c.Id, users.c.FirstName, users.c.LastName, users.c.Surname).where(users.c.Status == 'Ученик').limit(10))

def get_teachers():
    return query_rows(select(users.c.Id, users.c.FirstName, users.c.LastName, users.c.Surname).where(users.c.Status == 'Учитель').limit(10))

def search_all(text):
    q = '%'+text+'%'
    stmt = select(users.c.Id, users.c.FirstName, users.c.LastName, users.c.Surname).\
        where(or_(
            users.c.FirstName.like(q),
            users.c.LastName.like(q),
            users.c.Surname.like(q),
            )).limit(10)

    print(stmt)
    return query_rows(stmt)

def search_info(id):
    stmt = select(users).where(users.c.Id == id)
    print(stmt)
    return query_rows(stmt)

from sqlalchemy import create_engine
from sqlalchemy.ext.automap import automap_base
from sqlalchemy.orm import sessionmaker

class ZooDatabase:
    def __init__(self, user, password, host, database):
        self.engine = create_engine(f'mysql+pymysql://{user}:{password}@{host}/{database}')
        self.Base = automap_base()
        self.Session = sessionmaker(bind=self.engine)

    def prepare(self):
        self.Base.prepare(self.engine, reflect=True)

    def get_table(self, table_name):
        return self.Base.classes.get(table_name)

    def create_session(self):
        return self.Session()

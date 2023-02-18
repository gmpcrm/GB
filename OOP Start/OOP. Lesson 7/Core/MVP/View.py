import datetime

from abc import ABC, abstractmethod

class View(ABC):
    @abstractmethod
    def getDate(self):
        pass

    @abstractmethod
    def setDate(self, value: datetime.date):
        pass

    @abstractmethod
    def getFirstName(self):
        pass

    @abstractmethod
    def setFirstName(self, value: str):
        pass

    @abstractmethod
    def getLastName(self):
        pass

    @abstractmethod
    def setLastName(self, value: str):
        pass

    @abstractmethod
    def getPhone(self):
        pass

    @abstractmethod
    def setPhone(self, value: str):
        pass

    @abstractmethod
    def getCompany(self):
        pass

    @abstractmethod
    def setCompany(self, value: str):
        pass

    @abstractmethod
    def getEmail(self):
        pass

    @abstractmethod
    def setEmail(self, value: str):
        pass

    @abstractmethod
    def getDescription(self):
        pass

    @abstractmethod
    def setDescription(self, value: str):
        pass

    @abstractmethod
    def getImportInfo(self):
        pass

    @abstractmethod
    def getExportInfo(self):
        pass

    @abstractmethod
    def getSearchInfo(self):
        pass

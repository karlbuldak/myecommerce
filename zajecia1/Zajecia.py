class Zajecia:
    def __init__(self, nazwa_zajec, prowadzacy, studenci):
        self.nazwa_zajec = nazwa_zajec
        self.prowadzacy = prowadzacy
        self.studenci = studenci
        
    def zapiszStudenta(self, student):
        if len(self.studenci) < 10:
            self.studenci.append(student)
            return True
        else:
            return False

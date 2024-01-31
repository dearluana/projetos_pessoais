class Exercicio:
    def __init__(self, nome, descricao, grupo_muscular):
        self.nome = nome
        self.descricao = descricao
        self.grupo_muscular = grupo_muscular

    def __str__(self):
        return f"{self.nome}: {self.descricao} ({self.grupo_muscular})"


class Serie:
    def __init__(self, exercicio, repeticoes, carga_kg):
        self.exercicio = exercicio
        self.repeticoes = repeticoes
        self.carga_kg = carga_kg

    def __str__(self):
        return f"{self.exercicio.nome} - Repetições: {self.repeticoes}, Carga: {self.carga_kg} kg"


class RotinaTreino:
    dias_semana = ['Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado', 'Domingo']

    def __init__(self):
        self.dias_treino = {}

    def adicionar_treino(self, dia, serie):
        if dia not in self.dias_treino:
            self.dias_treino[dia] = [serie]
        else:
            self.dias_treino[dia].append(serie)

    def exibir_rotina(self):
        print("Rotina de Treinos:")
        for dia, series in self.dias_treino.items():
            print(f"\n{dia}:")
            for serie in series:
                print(f"\t{serie}")

    def calcular_imc(self, peso_kg, altura_m):
        try:
            imc = peso_kg / (altura_m ** 2)
            return round(imc, 2)
        except ZeroDivisionError:
            return 0.0


def criar_exercicio():
    nome = input("Nome do exercício: ")
    descricao = input("Descrição do exercício: ")
    grupo_muscular = input("Grupo Muscular: ")
    return Exercicio(nome, descricao, grupo_muscular)


def criar_serie():
    exercicio = criar_exercicio()
    repeticoes = int(input("Número de repetições: "))
    carga_kg = float(input("Carga (kg): "))
    return Serie(exercicio, repeticoes, carga_kg)


def obter_numero(mensagem):
    while True:
        try:
            return float(input(mensagem))
        except ValueError:
            print("Erro: Insira um número válido.")


rotina_luana = RotinaTreino()

# Adicionar treinos para cada dia da semana (até sábado)
for dia in RotinaTreino.dias_semana[:-1]:
    print(f"\nConfigurar treino para {dia}:")
    try:
        serie = criar_serie()
        rotina_luana.adicionar_treino(dia, serie)
    except Exception as e:
        print(f"Erro ao configurar treino para {dia}: {e}")

# Exibir a rotina de treino
rotina_luana.exibir_rotina()

# Calcular e exibir o IMC
peso = obter_numero("Digite o peso atual da Luana (kg): ")
altura = obter_numero("Digite a altura da Luana (metros): ")
imc = rotina_luana.calcular_imc(peso, altura)
print(f"\nO IMC atual da Luana é: {imc}")


class DiarioGestacao:
    def __init__(self):
        self.diario = {}

    def adicionar_registro(self, mes, peso_mamae_kg, peso_bebe_g, altura_bebe_cm, mediacoes, sintomas, comentarios, sexo_bebe=None):
        try:
            peso_mamae_kg = float(peso_mamae_kg)
            peso_bebe_g = float(peso_bebe_g)
            altura_bebe_cm = float(altura_bebe_cm)
        except ValueError:
            print("Erro: Peso da mamãe, peso do bebê e altura do bebê devem ser valores numéricos.")
            return

        registro = {
            'Peso da Mamãe (kg)': peso_mamae_kg,
            'Peso do Bebê (g)': peso_bebe_g,
            'Altura do Bebê (cm)': altura_bebe_cm,
            'Sexo do Bebê': sexo_bebe,
            'Medicações': mediacoes,
            'Sintomas': sintomas,
            'Comentários': comentarios
        }
        self.diario[mes] = registro

    def definir_sexo_bebe(self, mes, sexo_bebe):
        if mes in self.diario:
            self.diario[mes]['Sexo do Bebê'] = sexo_bebe
        else:
            print(f"Erro: Não há registro para o mês {mes}. Adicione um registro antes de definir o sexo do bebê.")

    def decidir_parto(self, mes, tipo_parto):
        if mes in self.diario:
            self.diario[mes]['Tipo de Parto'] = tipo_parto
        else:
            print(f"Erro: Não há registro para o mês {mes}. Adicione um registro antes de decidir o tipo de parto.")

    def exibir_diario(self):
        if not self.diario:
            print("Diário de gestação vazio.")
            return

        print("Diário de Gestação:")
        for mes, registro in sorted(self.diario.items()):
            print(f"\nMês {mes}:")
            for chave, valor in registro.items():
                print(f"{chave}: {valor}")


# Criação do diário de gestação
diario_gestacao_luana = DiarioGestacao()

# Adição de registros para os meses
diario_gestacao_luana.adicionar_registro(1, 60, 2500, 0.3, "Ácido fólico", "Náuseas, cansaço", "Início da gestação")
diario_gestacao_luana.adicionar_registro(2, 62, 10000, 3.0, "Vitamina D", "Aumento do apetite", "Primeira consulta médica")
diario_gestacao_luana.adicionar_registro(3, 65, 20000, 8.0, "Ferro", "Leve desconforto abdominal", "Ultrassom morfológico")

# Definição do sexo do bebê no quarto mês
diario_gestacao_luana.definir_sexo_bebe(4, "Feminino")

# Adição de registros para os meses seguintes
diario_gestacao_luana.adicionar_registro(5, 70, 40000, 22.0, "Vitamina D", "Início das aulas de preparação para o parto", "Chá de bebê")
diario_gestacao_luana.adicionar_registro(6, 72, 50000, 30.0, "Ferro", "Crescimento da barriga evidente", "Preparativos para o quarto do bebê")
diario_gestacao_luana.adicionar_registro(7, 75, 60000, 40.0, "Ácido fólico", "Dificuldade para dormir", "Curso de amamentação")
diario_gestacao_luana.adicionar_registro(8, 78, 70000, 50.0, "Vitamina D", "Consulta final com obstetra", "Preparativos finais")

# Decisão sobre o tipo de parto no nono mês
diario_gestacao_luana.decidir_parto(9, "Cesárea")

# Adição de registros para o 9º mês
diario_gestacao_luana.adicionar_registro(9, 80, 3200, 53.0, "Vitamina D, Ácido fólico", "Inchaço nos pés, ansiedade", "Preparativos finais")

# Tentativa de adicionar um registro com dados inválidos
diario_gestacao_luana.adicionar_registro(10, "a", 80000, 55000, "Ferro", "Outros sintomas", "Consulta de rotina")

# Exibição do diário de gestação
diario_gestacao_luana.exibir_diario()

🤖 Analisador de Frases Inteligente
Este projeto Java simula diferentes estilos de resposta automática com base no conteúdo e formato das frases enviadas. Ele funciona como um “robô conselheiro”, reagindo de maneira contextual e adaptativa.

🧠 Perfis de Resposta (“Robôs”)
O sistema possui múltiplos perfis que alteram o comportamento da resposta:

Robô	Comportamento
Padrão	Responde com base em perguntas, gritos, frases vazias ou uso de “eu”
Matemático	Interpreta frases com expressões matemáticas e resolve se possível
Personalizado	Permite configurar respostas específicas (ex: tom sarcástico ou formal)
Premium	Combina todos os comportamentos e adiciona frases mais elaboradas
Cada perfil é selecionado dinamicamente ou manualmente conforme o contexto do usuário.

🔍 Lógica de Análise
A aplicação identifica os seguintes elementos:

Frases vazias → "Não me incomode."

Perguntas (terminam com ?) → "Certamente" ou "Relaxa, eu sei o que estou fazendo!"

Frases em maiúsculas (gritos) → "Opa! Calma aí!"

Frases contendo “eu” → "A responsabilidade é sua"

Caso nenhum critério seja atendido → "Tudo bem, como quiser."

🧪 Exemplos
java
Entrada: ""  
→ Saída: "Não me incomode."

Entrada: "EU NÃO VOU FAZER ISSO?"  
→ Saída: "Relaxa, eu sei o que estou fazendo!"

Entrada: "2 + 2 * 3" (Modo matemático)  
→ Saída: "O resultado é 8."

Entrada: "Oi, tudo bem?" (Modo personalizado – formal)  
→ Saída: "Certamente."

📦 Requisitos
Java 8 ou superior

Interface com EditText e Button

Opcional: sistema de seleção ou detecção de perfil de robô

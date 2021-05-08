# Desafio-L-System
Desafio da matéria de Compiladores ministrada pelo MSc. Daniel de Souza Carvalho pela FTT - Faculdade de Tecnologia Termomecânica.

Projeto 2: L-Systems (análise e síntese)
Entrada: Texto com a definição da gramática da linguagem (análise)
Saída: Texto com gráfico (SVG ou X3D) - síntese
Referência: https://github.com/danielscarvalho/FTT-Compiladores-Python/blob/master/l-system.txt
Enviar o link para o código do projeto no GitHub
Informar no código o nome dos alunos membros do grupo
Livro online: http://algorithmicbopers/lsfp.pdf

--------------------------------------------------
Desafio 
Gramática da linguagem:

- Σ   ☞ Alfabeto da linguagem
- n   ☞ Passos, etapas
- ω   ☞ Axioma, condição inicial
- δ   ☞ Angulo
- pX  ☞ Regras de produção

Exemplo:
- Σ : F, +, -
- n : 3
- ω : F-F-F-F
- δ : 90º
- p1 : F → +FF

Iterações:
- 0: F-F-F-F
- 1: +FF-+FF-+FF-+FF
- 2: ++FF+FF-++FF+FF-++FF+FF-++FF+FF
- 3: +++FF+FF++FF+FF-+++FF+FF++FF+FF-+++FF+FF++FF+FF-+++FF+FF++FF+FF
---------------------------------------------------------------------

Projeto:

Análise
- Definir uma gramática em arquivo texto
- Ler arquivo com a definição da gramática
- Aplicar as regras de produção, recursivamente → Gerar o string final
- Definir a semântica para cada elemento do alfabeto da sua linguagem:
    + - Vira a direita
    - - Vira a esquerda
    F - Para frente desenhando
    f - Para frente sem desenhar
    [ - Pilha... etc...

Sínstese
- Gerar image com base no string final, em arquivo texto HTML
    2D - SVG - https://www.w3schools.com/graphics/svg_intro.asp
    3D - X3D - https://doc.x3dom.org/tutorials/basics/hello/index.html
    Alternativa: https://threejs.org/
- Salvar arquivo texto, pode ser svg ou x3d em HTML

Referencia:
- https://en.wikipedia.org/wiki/L-system
- http://www.algorithmicbotany.org/
- https://resources.wolframcloud.com/FunctionRepository/resources/LSystemPlot
- http://algorithmicbotany.org/papers/abop/abop.pdf

Vídeos:
- Coding Challenge #16: L-System Fractal Trees - https://www.youtube.com/watch?v=E1B4UoSQMFw
- 8.5: L-Systems - The Nature of Code - https://www.youtube.com/watch?v=f6ra024-ASY&t=19s

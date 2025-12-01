# Variables
CXX = g++
CXXFLAGS = -Wall -g
INPUT = input.txt

# --- EJERCICIOS ---

1: 01-p1
	./01-p1 $(INPUT)

2: 02-p2
	./02-p2 $(INPUT)

# --- REGLA ---
# Esto le dice a Make: "Si necesitas un ejecutable, búscalo en los .cpp"
%: %.cpp
	$(CXX) $(CXXFLAGS) -o $@ $<

# Limpieza
clean:
	rm -f 01-p1 02-p2
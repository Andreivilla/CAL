from graph import Graph
class Prim:
    def __init__(self, g, s):
        self.s = s
        self.g = g
        self.k = [float('inf') for i in range(self.g.N)]
        self.p = [-1 for i in range(self.g.N)]
        self.q = [(i, self.k[i]) for i in range(self.g.N)]

    def agm(self):
        self.p[self.s] = 0 
        self.k[self.s] = 0
        
        for i in range(self.g.N): # O(1) executado n vezes
            self.q[i] = (i, self.k[i])

        while(len(self.q) != 0): # O(1) executado n vezes
            self.atualizaQ() # O(n)

            #adicionado para printar cada passo da execução do programa
            print(f'P {self.p}')
            print(f'K {self.k}')
            print(f'Q {self.q}')
            print("-------------------")

            u = self.minQ(self.q) # O(n)           
            self.q.remove(u) 
            for v in range(self.g.N): # O(1) executado n vezes
                if self.g.adjacente(u[0], v): 
                    if self.verificaVQ(v, self.q) and self.g.peso(u[0], v) < self.k[v]: # O(n) verificaVQ
                        self.p[v] = u[0]
                        self.k[v] = self.g.peso(u[0], v)

    def verificaVQ(self, v, q): # O(n)
        for i in q:
            if i[0] == v:
                return True
        return False
    
    def minQ(self, q): # O(n)
        minK = q[0][1]
        minTupla = q[0]
        for i in q:
            if i[1] < minK:
                minTupla = i
                minK = i[1]
        return minTupla

    def atualizaQ(self): # O(n)
        for i in range(len(self.q)):
            lst = list(self.q[i])
            lst[1] = self.k[self.q[i][0]]
            self.q[i] = tuple(lst)
                

g = Graph(5)
g.graph = [[0, 8, 9, 0, 0, 6], 
            [8, 0, 2, 5, 11, 7], 
            [9, 2, 0, 6, 0, 0], 
            [0, 5, 6, 0, 3, 10], 
            [0, 11, 0, 3, 0, 9], 
            [6, 7, 0, 10, 9, 0]]
prim = Prim(g,0)
prim.agm()
print(prim.p)


# Project 2 - 
For this project, we are working with the codes we wrote in project 1. We will build a more constructional classes and extend our program by simulating multiple types of rules and boundary conditions. We will use test-driven strategy for this project

## CellState
We will create an enumerated type cellstate to represent the states of cells instead of using boolean values in project 1. This enumerated type should also include constructors to stores the symbol associated with each CellState and Map which stores symbol with its state. It should also include a get state method which returns the CellState associated with a given symbol. As a toString method which returns the symbol that represents the CellState Value

## Cell
Instead of using boolean value to represent the state of the cell, we will change the code to use enumerated type cellstate to represent the state of the cell.

## Generation
Most of Generation code should remain unchanged from project 1

## Rule
The Rule class will now have to subclass ElementaryRule and TotalisticRule. It will also add have two abstract methods which is getNeighborhood and evolve. The getNeighborhood method return the neighborhood of the cell with give index. The evolve method will evolve the next generation based on the rule and the neighborhood of the current cell

## ElementaryRule
The ElementaryRule governs the evolution of an elementary cellular automaton.

## TotallisticRule
The TotallisticRule will check the total number of cells in the On state on the radius of 2

## BoundaryConditions
The boundary conditions governs the evolution of the first and last cells in a generation

##CircularBoundaryConditions
The CircularBoundaryConditions accounts cells from the another end as it neighbor

##FixedBoundaryConditions
The FixedBoundaryCOndition accounts there are infinite number of cells extending to the left and right.

##Automaton
Most Automation code should remain same from project 1

##AutomatonMeasurements
The AutomatonMeasurements calculate the quantities of how an automaton evolves by finding the hammingDistance and subruleCount

### Todo List
[] create Junit test for original functioning code from project 1 making sure that the change of code of not change the way it works

[] create Junit test for new method make sure it works properly

[] creating new methods and class as the project requirement

[] save change and commit to github while working



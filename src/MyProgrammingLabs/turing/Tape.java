package MyProgrammingLabs.turing;

/**
 * This class represents turing tapes used by the turing machine.
 */
public class Tape {
    Cell currentcell; // points to the current cell on a turing tape

    /**
     * Constructs a cell that initially consists of a single cell
     */
    Tape() {
        this.currentcell = new Cell();    
    }

    
    /**
     * returns the pointer that points to the current cell.
     * 
     * @return
     */
    public Cell getCurrentCell() {
        return currentcell.next.prev; // ?? 
    }

    
    /**
     * returns the char from the current cell
     * @return
     */
    public char getContent() {
        return currentcell.content;
    }

    
    /**
     * changes the char in the current cell to the specified value
     * @param ch
     */
    public void setContent(char ch) {
        currentcell.content = ch;
    }

    
    /**
     * moves the current cell one position to the left along the tape. Note that if
     * the current cell is the leftmost cell that exists, then a new cell must be
     * created and added to the tape at the left of the current cell, and then the
     * current cell pointer can be moved to point to the new cell. The content of
     * the new cell should be a blank space. (Remember that the Turing machine's
     * tape is conceptually infinite, so your linked list must be prepared to expand
     * on-demand when the machine wants to move past the current end of the list.)
     */
    public void moveLeft() {
        if (currentcell.prev != null) { // current cell is NOT leftmost
            // move it one step to the left
            currentcell.prev = currentcell.prev.prev;
            currentcell.next = currentcell.prev;

        } else { // current cell is leftmost
            // create new cell with blank space
            Cell newCell = new Cell();
            // add new cell to the left of the current cell
            newCell.next = currentcell; // or currentcell.prev = newCell;
            // let current cell pointer point to the new cell
            currentcell.prev = newCell;            
        }

    }

    /**
     * moves the current cell one position to the right along the tape. Note that if
     * the current cell is the rightmost cell that exists, then a new cell must be
     * created and added to the tape at the right of the current cell, and then the
     * current cell pointer can be moved to point to the new cell. The content of
     * the new cell should be a blank space.
     */    
    public void moveRight() {
        if (currentcell.next != null) { // current cell is NOT rightmost
            // move it one step to the right

        } else { // current cell is rightmost
            // create new cell with blank space
            Cell newCell = new Cell();
            // add new cell to the right of the current cell
            currentcell.next = newCell; // or newCell.prev = currentcell

            // let current cell pointer point to the new cell
            newCell.prev = currentcell;

        }

    }
    
    /**
     * returns a String consisting of the chars from all the cells on the tape, read
     * from left to right, except that leading or trailing blank characters should
     * be discarded. The current cell pointer should not be moved by this method; it
     * should point to the same cell after the method is called as it did before.
     * You can create a different pointer to move along the tape and get the full
     * contents. (This method is the hardest one to implement.)
     * 
     * @return
     */

    public String getTapeContents() {
        return "Not yet implemented";

    }
}

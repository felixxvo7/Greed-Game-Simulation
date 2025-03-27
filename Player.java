//-----------------------------------------
// INTERFACE: Player
//
// REMARKS: Defines the contract for a game player (human or AI).
//          Implementations must provide a method to select moves.
//-----------------------------------------
public interface Player 
{
    int chooseMove();
}

package agh.ics.oop;

/**
 * Interface that observes change in position
 *
 *
 * @author Piotreqsl
 */

public interface IPositionChangeObserver {
    /**
     * Function that deals with position changes.
     *
     * @param oldPosition The old position
     * @param newPosition The new position
     */
    void positionChanged(Vector2d oldPosition, Vector2d newPosition);

}
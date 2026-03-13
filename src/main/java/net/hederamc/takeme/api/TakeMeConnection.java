package net.hederamc.takeme.api;

public interface TakeMeConnection {
    default boolean canConnectTakeMe() {
        throw new UnsupportedOperationException();
    }

    default void setCanConnectTakeMe(boolean bool) {
        throw new UnsupportedOperationException();
    }
}

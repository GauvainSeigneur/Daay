package com.gauvain.seigneur.view.action

data class ActionEvent<EventType>(
    val uiInputHandler: UiInputHandler<EventType>,
    val event: EventType,
) : UiAction.NoArgs {
    override fun execute() {
        uiInputHandler.handle(event)
    }
}

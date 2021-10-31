//@@author ashrafjfr

package seedu.command;

import seedu.contact.Contact;
import seedu.ui.ExceptionTextUi;
import seedu.ui.TextUi;

public class ViewContactCommand extends Command {
    private final int contactIndex;

    public ViewContactCommand(int contactIndex) {
        this.contactIndex = contactIndex;
    }

    public int getIndex() {
        return contactIndex;
    }

    public void execute() {
        try {
            Contact viewingContact = contactList.getContactAtIndex(contactIndex);
            assert contactIndex >= 0 && contactIndex < contactList.getListSize();
            TextUi.viewContactMessage(viewingContact, contactIndex);
        } catch (IndexOutOfBoundsException e) {
            ExceptionTextUi.numOutOfRangeMessage(contactList.getListSize());
        }
    }
}

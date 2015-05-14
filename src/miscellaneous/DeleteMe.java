package miscellaneous;

import java.io.Serializable;

/**
 * This class is intented to seprate the delete-method from the insert- and update-method in the DatabaseController.
 * @author Filip
 *
 */
public class DeleteMe implements Serializable {
	private Object objectToDelete;

	public DeleteMe(Object objToDelete){
		this.objectToDelete = objToDelete;
	}
	public Object getObject() {
		return objectToDelete;
	}

}

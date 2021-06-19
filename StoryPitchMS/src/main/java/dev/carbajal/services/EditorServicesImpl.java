package dev.carbajal.services;

import java.util.List;

import dev.carbajal.models.Editor;
import dev.carbajal.repositories.EditorDAO;
import dev.carbajal.repositories.EditorDAOImpl;

public class EditorServicesImpl implements EditorServices {
	
	private EditorDAO ed = new EditorDAOImpl();

	@Override
	public Editor addEditor(Editor editor) {

		return ed.addEditor(editor);
	}

	@Override
	public List<Editor> getAllEditorsByCommittee(String committee) {

		return ed.getAllEditorsByCommittee(committee);
	}

	@Override
	public List<Editor> getEditorsByLogin(String username, String password) {

		return ed.getEditorsByLogin(username, password);
	}

	@Override
	public Editor getEditor(String username, String committee) {

		return ed.getEditor(username, committee);
	}

	@Override
	public Editor getEditorById(int editorId) {

		return ed.getEditorById(editorId);
	}

	@Override
	public void updateEditor(Editor editor) {
		
		ed.updateEditor(editor);
	}

	@Override
	public void deleteEditor(Editor editor) {
		
		ed.deleteEditor(editor);
	}
}

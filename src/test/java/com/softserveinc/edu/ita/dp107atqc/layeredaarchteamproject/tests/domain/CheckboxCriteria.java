package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.CheckBox;


public class CheckboxCriteria implements ISpecification{

  private CheckBox checkbox;
  private Specification specification;

  public CheckboxCriteria(CheckBox checkbox,
          Specification specification) {
    this.checkbox = checkbox;
    this.specification = specification;
  }


  public static CheckboxCriteria get(CheckBox checkbox, Specification specification) {
    return new CheckboxCriteria(checkbox, specification);
  }

  public CheckboxCriteria isChecked() {
    this.specification.add(this.checkbox.isSelected(), "Checkbox is unchecked.");
    return this;
  }

  public CheckboxCriteria isUnChecked() {
    this.specification.add(!this.checkbox.isSelected(), "Checkbox is checked.");
    return this;
  }

  @Override
  public Specification next() {
    return this.specification;
  }
}
